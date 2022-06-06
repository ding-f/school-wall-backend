package com.schoolwall.service.impl;

import com.schoolwall.entity.Posts;
import com.schoolwall.mapper.PostsMapper;
import com.schoolwall.service.PostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fuding
 * @since 2022-03-10
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements PostsService {

    @Autowired
    PostsMapper postsMapper;

    @Override
    public Posts getPostAllInfo(Long postId) {
        return postsMapper.getPostAllInfo(postId);
    }
}
