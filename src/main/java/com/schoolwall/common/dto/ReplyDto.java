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
 * @since 2022 2022/4/26 16:56
 */

@ApiModel("评论信息DTO")
@Data
public class ReplyDto {

    @ApiModelProperty(value = "被回复文章ID(父子)",required = true, example = "123")
    private Long postID;    //父子需要

    @ApiModelProperty(value = "被回复墙贴的作者ID(父)",required = true, example = "13")
    private Integer authorID;    //父需要

    @ApiModelProperty(value = "父级评论ID(子)",required = true, example = "1")
    private Long parentID;     //子需要

    @ApiModelProperty(value = "评论内容(父子)",required = true, example = "小哥哥可以加个微信吗？")
    private String content;   //父子需要

    @ApiModelProperty(value = "接收用户ID(子)",required = true, example = "1")
    private Integer receiverID; //子需要

    @ApiModelProperty(value = "逻辑判断插入子表/父表(false子,true父)",required = true, example = "1")
    private Boolean isFatherReply;  //逻辑判断需要

}
