package com.schoolwall.service.impl;

import com.schoolwall.entity.User;
import com.schoolwall.mapper.UserMapper;
import com.schoolwall.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fuding
 * @since 2022-03-16
 */


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    void insert(){
        //userMapper.insert();      //只是想证明一下MyBatis Plus的Mapper方法有insert，而Service有save方法
    }
}
