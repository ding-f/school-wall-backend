package com.schoolwall.service.impl;

import com.schoolwall.entity.Posts;
import com.schoolwall.entity.UserSubscriptions;
import com.schoolwall.mapper.UserSubscriptionsMapper;
import com.schoolwall.service.UserSubscriptionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fuding
 * @since 2022-05-21
 */
@Service
public class UserSubscriptionsServiceImpl extends ServiceImpl<UserSubscriptionsMapper, UserSubscriptions> implements UserSubscriptionsService {

    @Autowired
    UserSubscriptionsMapper userSubscriptionsMapper;

    @Override
    public List<Posts> userSubPosts(Long userId) {
        List<Posts> list = userSubscriptionsMapper.userSubPosts(userId);
        return list;
    }
}
