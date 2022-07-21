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
 * @since 2022 2022/4/20 15:34
 */

@ApiModel("微信用户信息DTO")
@Data
public class WXInfoDto {

    @ApiModelProperty(value = "微信用户头像链接", required = true, example = "https://thirdwx.qlogo.cn/mmopen/vi_32/Ne1NOq8ScicXNY7U8qtbU4JXAGNKOuibrrRKDRHxHvPcR5EoD0K2cDIU1Xyk16yUdcKON61RRTRt0SianCegtsYzg/132" )
    private String avatarUrl;

    @ApiModelProperty(value = "微信用户昵称", required = true, example = "Immortal\uD83C\uDF40" )
    private String nickName;

    @ApiModelProperty(value = "微信用户OpenID", required = true, example = "o7DTV4p5l0****vmSTss" )
    @NotBlank(message = "openID 为空，请尝试重新授权~")
    private String code;

}
