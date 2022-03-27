package com.schoolwall.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/3/20 4:59 PM
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SonReplyVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nickName;

    private String avatarUrl;

    private String content;

    private String receiverNick;

    private LocalDateTime sonReplyDate;


}
