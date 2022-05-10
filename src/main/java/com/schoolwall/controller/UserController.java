package com.schoolwall.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.schoolwall.common.dto.WXInfoDto;
import com.schoolwall.common.lang.Result;
import com.schoolwall.entity.User;
import com.schoolwall.common.dto.AccountPasswdDto;
import com.schoolwall.service.UserService;
import com.schoolwall.shiro.JwtToken;
import com.schoolwall.util.JwtUtil;
import com.schoolwall.util.WXRequestUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fuding
 * @since 2022-03-16
 */
@RestController
@RequestMapping("/schoolwall")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/user/enroll")
    public Result enrollUser(@RequestBody @Validated User user){

        if(userService.save(user)){
            return Result.succ(user);
        }

        return  Result.fail("注册失败");
    }

    @PostMapping("/user/login")
    public Result userLogin(@RequestBody @Validated AccountPasswdDto accountPasswd, HttpServletResponse httpResponse){

//        System.out.println(accountPasswd.toString());


        QueryWrapper<User> userQueryWrapper;

        final String EMAILREGEX = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

        if (ReUtil.isMatch(EMAILREGEX,accountPasswd.getUser())) {
            userQueryWrapper = new QueryWrapper<User>().eq("user_name", accountPasswd.getUser());
        }else {
            userQueryWrapper = new QueryWrapper<User>().eq("student_num", accountPasswd.getUser());
        }


        User user= userService.getOne(userQueryWrapper);
        Assert.notNull(user,"用户不存在");

        if(!user.getPassword().equals(SecureUtil.md5(accountPasswd.getPasswd()+"ding"))){

            return Result.fail("账号或密码有误");

        }

        String jwt = jwtUtil.generateToken(user.getId());

        httpResponse.setHeader("Authorization",jwt);
        httpResponse.setHeader("Access-control-Expose-Headers", "Authorization");



        return Result.succ(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUserName())
                .put("avatar", user.getAvatarUrl())
                .put("email", user.getEmail())
                .map()
        );

    }

    @PostMapping("/user/wx/login")
    public Result wxLogin(@Validated @RequestBody WXInfoDto wxInfoDto,HttpServletResponse httpResponse) throws IOException {

        System.out.println(wxInfoDto.toString());   //TEST

        WXRequestUtil wxRequestUtil=new WXRequestUtil();

        String wxResJSON= wxRequestUtil.getOppenID(wxInfoDto.getCode());
        JSONObject jsonObject = JSONUtil.parseObj(wxResJSON);

        //微信不会把 session_key 的有效期告知开发者。我们会根据用户使用小程序的行为对 session_key 进行续期。用户越频繁使用小程序，session_key 有效期越长。
        String sessionKey = jsonObject.getStr("session_key");
        String openID = jsonObject.getStr("openid");

        System.out.println("\"session_key\":"+sessionKey+"\"openid\":" + openID);   //TEST

        QueryWrapper<User> userQueryWrapper=new QueryWrapper<User>()
                .select("id","open_id","nick_name","avatar_url","use_mask","wx_name","wx_avatar_url","enable","register_date","role")
                .eq("open_id",openID);

        User user= userService.getOne(userQueryWrapper);
        if(user != null){   //说明使用过小程序，已经注册了用户OpenID
            if(user.getEnable().equals("0")){
                return Result.fail("该用户已被封号");
            }
            //更新微信网名
            if(!user.getWxName().equals(wxInfoDto.getNickName()) && user.getUseMask().equals("0")) {
                LambdaUpdateWrapper<User> userLambdaUpdateWrapper=new LambdaUpdateWrapper<>();
                userLambdaUpdateWrapper.eq(User::getId,user.getOpenId()).set(User::getWxName,wxInfoDto.getNickName());

                String updateUserWXName = userService.update(userLambdaUpdateWrapper) ? "更新微信网名成功" : "更新微信网名失败，请检查数据库！";
                System.out.println(updateUserWXName);
            }
            //更新微信头像链接
            if(!user.getWxAvatarUrl().equals(wxInfoDto.getAvatarUrl()) && user.getUseMask().equals("0")){
                LambdaUpdateWrapper<User> userLambdaUpdateWrapper=new LambdaUpdateWrapper<>();
                userLambdaUpdateWrapper.eq(User::getOpenId,user.getOpenId()).set(User::getWxAvatarUrl,wxInfoDto.getAvatarUrl());

                String updateUserWXURL= userService.update(userQueryWrapper) ? "更新微信头像成功":"更新用户图像失败";
                System.out.println(updateUserWXURL);
            }

            //登录成功签证JWT
            String loginJwt = jwtUtil.generateToken(user.getId());
            httpResponse.setHeader("Authorization",loginJwt);
            httpResponse.setHeader("Access-control-Expose-Headers", "Authorization");

            return Result.succ(user);
        }else {     //未使用过小程序，将OpenID注册成一个新用户

            if(!StrUtil.hasEmpty(openID)){
                User newUser = new User();

                newUser.setOpenId(openID)
                .setWxName(wxInfoDto.getNickName())
                .setWxAvatarUrl(wxInfoDto.getAvatarUrl());

                userService.save(newUser);
                QueryWrapper<User> enrollUserQuery=new QueryWrapper<User>()
                        .select("id","open_id","nick_name","avatar_url","use_mask","wx_name","wx_avatar_url","enable","register_date","role")
                        .eq("open_id",openID);
                User enrollUser = userService.getOne(enrollUserQuery);

                //注册成功签证JWT
                String enrollJwt = jwtUtil.generateToken(enrollUser.getId());
                httpResponse.setHeader("Authorization",enrollJwt);
                httpResponse.setHeader("Access-control-Expose-Headers", "Authorization");

                return Result.succ(enrollUser);

            }else {
                return Result.fail("向微信官方请求用户信息失败");
            }
//            userService.save();

        }

    }

    @RequiresAuthentication
    @GetMapping("/user/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}
