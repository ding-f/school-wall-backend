package com.schoolwall.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.schoolwall.common.dto.WXInfoDto;
import com.schoolwall.common.lang.Result;
import com.schoolwall.entity.User;
import com.schoolwall.common.dto.AccountPasswdDto;
import com.schoolwall.service.UserService;
import com.schoolwall.shiro.JwtToken;
import com.schoolwall.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public Result wxLogin(@Validated @RequestBody WXInfoDto wxInfoDto) throws IOException {

        System.out.println(wxInfoDto.toString());





        return null;
    }

    @RequiresAuthentication
    @GetMapping("/user/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}
