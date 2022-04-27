package com.schoolwall.shiro;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/4/13 19:53
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountProfile implements Serializable {

    private Integer id;

//    private String userName;
//
//    private String avatarUrl;
//
//    private String email;
    private  String openId;



}
