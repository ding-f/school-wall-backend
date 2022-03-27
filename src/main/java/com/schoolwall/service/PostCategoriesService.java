package com.schoolwall.service;

import com.schoolwall.entity.PostCategories;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fuding
 * @since 2022-03-15
 */

public interface PostCategoriesService extends IService<PostCategories> {

    public List<PostCategories> selectCountPostByCategories();

}
