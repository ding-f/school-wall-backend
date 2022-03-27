package com.schoolwall.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/3/20 2:51 PM
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ReplyVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;



    private String nickName;

    private String avatarUrl;


    private String content;

    private LocalDateTime fatherReplyDate;


    private List<SonReplyVo> sonList;





}
