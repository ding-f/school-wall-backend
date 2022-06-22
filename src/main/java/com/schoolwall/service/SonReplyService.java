package com.schoolwall.service;

import com.schoolwall.entity.SonReply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.schoolwall.entity.vo.UserReplyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fuding
 * @since 2022-03-21
 */
public interface SonReplyService extends IService<SonReply> {
    List<UserReplyVo> selectUserReplys (Long userId);

}
