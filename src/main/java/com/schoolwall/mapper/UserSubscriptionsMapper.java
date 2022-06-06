package com.schoolwall.mapper;

import com.schoolwall.entity.Posts;
import com.schoolwall.entity.UserSubscriptions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fuding
 * @since 2022-05-21
 */

@Mapper
public interface UserSubscriptionsMapper extends BaseMapper<UserSubscriptions> {
    List<Posts> userSubPosts(@Param("user_id") Long userId);
}
