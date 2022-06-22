package com.schoolwall.common.dto;

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
@Data
public class DelCommentDto {

    private Long userId;

    private Long replyId;

    private Boolean from;

}
