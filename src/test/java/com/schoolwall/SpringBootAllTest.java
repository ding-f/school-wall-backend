package com.schoolwall;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.schoolwall.common.dto.WXInfoDto;
import com.schoolwall.entity.User;
import com.schoolwall.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/4/18 20:14
 */
@SpringBootTest
class SpringBootAllTest {
    @Autowired
    UserService userService;

    @Test
    void enrollUser(){
        User user =new User();

        user.setUserName("fuding@qq.com");
        user.setPassword(SecureUtil.md5("999999999"+"ding"));
        user.setStudentNum("2020020040");

        System.out.println(userService.save(user));
    }

    @Test
    void selectUser(){
        String openID="";     //测试""  null


        QueryWrapper<User> userQueryWrapper=new QueryWrapper<User>()
                .select("open_id","use_mask","avatar_url","nick_name","enable","register_date","role")
                .eq("open_id",openID);

//        QueryWrapper<User> userQueryWrapperCount=new QueryWrapper<User>()
//                .select("open_id")
//                .eq("open_id",openID);
        User user= userService.getOne(userQueryWrapper);

//        int i=userService.count();
        System.out.println(user);       //null
        System.out.println(openID);     //null

//        System.out.println(i);
    }

    @Test
    void updateUser(){
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<User>()
                .select("id","open_id","use_mask","avatar_url","nick_name","enable","register_date","role")
                .eq("open_id","1111");

        WXInfoDto wxInfoDto=new WXInfoDto();
        wxInfoDto.setNickName("Immortal");
        User user= userService.getOne(userQueryWrapper);
        LambdaUpdateWrapper<User> userLambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        userLambdaUpdateWrapper.eq(User::getId,user.getId()).set(User::getWxName,wxInfoDto.getNickName());

        System.out.println(userService.update(userLambdaUpdateWrapper));
    }
}
