package com.schoolwall.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
