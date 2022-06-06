package com.schoolwall.service;

import com.schoolwall.entity.Posts;
import com.schoolwall.entity.UserSubscriptions;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fuding
 * @since 2022-05-21
 */
public interface UserSubscriptionsService extends IService<UserSubscriptions> {
    List<Posts> userSubPosts(@Param("user_id") Long userId);
}
