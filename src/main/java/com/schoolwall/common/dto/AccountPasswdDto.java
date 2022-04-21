package com.schoolwall.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/4/16 20:42
 */
@Data
public class AccountPasswdDto {


    @NotBlank(message = "用户名不能为空")
    private String user;

    @NotBlank(message = "密码不能为空")
    private String passwd;

}
