package com.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author fuding
 * @since 2022-03-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sw_posts")
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private LocalDateTime date;

    private String content;

    private String title;

    private String enable;

    private LocalDateTime modified;

    private String type;

    private Integer totalComments;

    private String postMediumImage;

    private Integer likeCount;

    private Integer pageviews;

    private Integer categoryId;

    @TableField(exist = false)
    private List postAllImages;

    @TableField(exist = false)
    private List avatarUrls;

}