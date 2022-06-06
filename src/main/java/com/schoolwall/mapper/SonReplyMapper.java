package com.schoolwall.mapper;

import com.schoolwall.entity.SonReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.schoolwall.entity.vo.UserReplyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fuding
 * @since 2022-03-21
 */
@Mapper
public interface SonReplyMapper extends BaseMapper<SonReply> {
    List<UserReplyVo> selectUserReplys (@Param("user_id") Long userId);
}
