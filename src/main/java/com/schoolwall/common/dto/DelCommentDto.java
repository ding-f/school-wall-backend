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
 * @since 2022 2022/6/16 14:12
 * 删除评论信息
 */

@ApiModel("删除评论信息DTO")
@Data
public class DelCommentDto {

    @ApiModelProperty(value = "请求删除评论的用户ID", required = true, example = "13")
    private Long userId;

    @ApiModelProperty(value = "父/子评论ID", required = true, example = "1")
    private Long replyId;

    @ApiModelProperty(value = "判断删除父子评论（true为子，false为父）", required = true, example = "13")
    private Boolean from;

}
