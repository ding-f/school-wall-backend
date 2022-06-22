package com.schoolwall.service.impl;

import com.schoolwall.entity.SonReply;
import com.schoolwall.entity.vo.UserReplyVo;
import com.schoolwall.mapper.SonReplyMapper;
import com.schoolwall.service.SonReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fuding
 * @since 2022-03-21
 */
@Service
public class SonReplyServiceImpl extends ServiceImpl<SonReplyMapper, SonReply> implements SonReplyService {

    @Autowired
    SonReplyMapper sonReplyMapper;

    @Override
    public List<UserReplyVo> selectUserReplys(Long userId) {
        return sonReplyMapper.selectUserReplys(userId);
    }
}
