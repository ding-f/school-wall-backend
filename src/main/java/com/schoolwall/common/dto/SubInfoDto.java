package com.schoolwall.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/5/21 19:25
 */

@ApiModel("订阅信息DTO")
@Data
public class SubInfoDto {
    @ApiModelProperty(value = "被订阅的分类ID",required = true, example = "1")
    private Integer categoryId;

    @ApiModelProperty(value = "订阅用户的OpenID", allowEmptyValue=true, example = "")
    private String openId;

    @ApiModelProperty(value = "是否已经订阅",notes = "1表示已经订阅，其他数值表示未订阅",required = true)
    private Integer subTab;
}
