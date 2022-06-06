package com.schoolwall.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/5/24 17:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserReplyVo {
    private Long id;
    private Long postId;
    private String content;
    private Long receiverId;
    private String wxName;
    private LocalDateTime sonReplyDate;
    private Boolean from;
}
