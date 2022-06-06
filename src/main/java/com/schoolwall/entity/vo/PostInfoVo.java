package com.schoolwall.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/5/29 10:14
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PostInfoVo {

    private Long id;

    private Long autId;

    private String autWxUrl;

    private String autWxName;

    private String autEnable;

    private String autRole;

    private String title;

    private String content;

    private String type;

    private String postImage0;

    private String postImage1;

    private String postImage2;

    private String postImage3;

    private String postImage4;

    private String postImage5;

    private String postImage6;

    private String postImage7;

    private String postImage8;

    private Integer pageviews;

    private Integer totalComments;

    private Integer likeCount;

    private String pEnable;

    private String postDate;

    private List<PostLikerVo> postLikers;

}
