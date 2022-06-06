package com.schoolwall.service;

import com.schoolwall.entity.Posts;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fuding
 * @since 2022-03-10
 */
public interface PostsService extends IService<Posts> {

    Posts getPostAllInfo(Long postId);

}
