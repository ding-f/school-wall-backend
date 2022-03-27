package com.schoolwall.mapper;

import com.schoolwall.entity.PostCategories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fuding
 * @since 2022-03-15
 */

@Component(value = "PostCategoriesMapper")
public interface PostCategoriesMapper extends BaseMapper<PostCategories> {
    List<PostCategories> selectCountPostByCategories();

}
