package com.schoolwall.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/5/17 22:01
 */
@ApiModel("墙贴信息DTO")
@Data
public class PostInfoDto {

    @ApiModelProperty(value = "墙贴标题", required = true, example = "测试发布墙贴")
    String title;

    @ApiModelProperty(value = "墙贴内容", required = true, example = "理想主义的花，终将会盛开在浪漫主义的土壤里，我的热情永远不会消失在现实的平凡当中；如果有一天 我变得和普通人一样，请让我曾经的热情把我烧成灰烬。")
    String content;

    @ApiModelProperty(value = "墙贴分类", required = true, example = "1")
    Integer categoryId;

    @ApiModelProperty(value = "墙贴图片1（文件名，需图片处理服务器生成,否则插入不能显示）", example = "image0.jpg" )
    String postImage0;

    @ApiModelProperty(value = "墙贴图片1（文件名，需图片处理服务器生成,否则插入不能显示）", example = "image0.jpg" )
    String postImage1;

    @ApiModelProperty(value = "墙贴图片1（文件名，需图片处理服务器生成,否则插入不能显示）", example = "image0.jpg" )
    String postImage2;

    @ApiModelProperty(value = "墙贴图片1（文件名，需图片处理服务器生成,否则插入不能显示）", example = "image0.jpg" )
    String postImage3;

    @ApiModelProperty(value = "墙贴图片1（文件名，需图片处理服务器生成,否则插入不能显示）", example = "image0.jpg" )
    String postImage4;

    @ApiModelProperty(value = "墙贴图片1（文件名，需图片处理服务器生成,否则插入不能显示）", example = "image0.jpg" )
    String postImage5;

    @ApiModelProperty(value = "墙贴图片1（文件名，需图片处理服务器生成,否则插入不能显示）", example = "image0.jpg" )
    String postImage6;

    @ApiModelProperty(value = "墙贴图片1（文件名，需图片处理服务器生成,否则插入不能显示）", example = "image0.jpg" )
    String postImage7;

    @ApiModelProperty(value = "墙贴图片1（文件名，需图片处理服务器生成,否则插入不能显示）", example = "image0.jpg" )
    String postImage8;

//    ArrayList photoList;
}
