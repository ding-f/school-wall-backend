package com.schoolwall.mapper;

import com.schoolwall.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fuding
 * @since 2022-03-16
 */
@Component(value = "UserMapper")
public interface UserMapper extends BaseMapper<User> {

}
