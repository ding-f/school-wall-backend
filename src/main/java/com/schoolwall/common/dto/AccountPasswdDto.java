package com.schoolwall.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("用户登陆DTO")
@Data
public class AccountPasswdDto {

    @ApiModelProperty(value = "登陆用户名（邮箱/学号）", required = true, example = "2020020000" )
    @NotBlank(message = "用户名不能为空")
    private String user;

    @ApiModelProperty(value = "登陆密码", required = true, example = "zhuding123" )
    @NotBlank(message = "密码不能为空")
    private String passwd;

}
