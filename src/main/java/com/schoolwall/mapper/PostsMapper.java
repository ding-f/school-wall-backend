package com.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.schoolwall.entity.Posts;
import com.schoolwall.entity.vo.PostInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fuding
 * @since 2022-03-10
 */

@Mapper
public interface PostsMapper extends BaseMapper<Posts> {

    Posts getPostAllInfo(@Param("id") Long postId);
}
