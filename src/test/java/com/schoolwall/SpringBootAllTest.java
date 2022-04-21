package com.schoolwall;

import cn.hutool.crypto.SecureUtil;
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
}
