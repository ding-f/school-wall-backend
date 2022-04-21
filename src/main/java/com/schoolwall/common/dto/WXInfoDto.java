package com.schoolwall.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/4/20 15:34
 */
@Data
public class WXInfoDto {

    private String avatarUrl;

    private String nickName;

    @NotBlank(message = "openID 为空，请尝试重新授权~")
    private String code;

}
