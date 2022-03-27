package com.schoolwall.service.impl;

import com.schoolwall.entity.PostCategories;
import com.schoolwall.mapper.FatherReplyMapper;
import com.schoolwall.mapper.PostCategoriesMapper;
import com.schoolwall.service.PostCategoriesService;
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
 * @since 2022-03-15
 */
@Service
public class PostCategoriesServiceImpl extends ServiceImpl<PostCategoriesMapper, PostCategories> implements PostCategoriesService {

    @Autowired
    PostCategoriesMapper postCategoriesMapper;

    @Override
    public List<PostCategories> selectCountPostByCategories() {
        List<PostCategories> categorisesConutList = postCategoriesMapper.selectCountPostByCategories();
        return categorisesConutList;
    }
}
