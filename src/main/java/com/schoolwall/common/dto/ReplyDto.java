package com.schoolwall.common.dto;

import lombok.Data;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/4/26 16:56
 */

@Data
public class ReplyDto {

    private Long postID;    //父子需要

    private Integer authorID;    //父需要

    private Long parentID;     //子需要

    private String content;   //父子需要

    private Integer receiverID; //子需要

    private Boolean isFatherReply;  //逻辑判断需要

}
