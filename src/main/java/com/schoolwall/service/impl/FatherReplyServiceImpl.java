package com.schoolwall.service.impl;

import com.schoolwall.entity.FatherReply;
import com.schoolwall.entity.vo.ReplyVo;
import com.schoolwall.mapper.FatherReplyMapper;
import com.schoolwall.service.FatherReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fuding
 * @since 2022-03-21
 */
@Service
public class FatherReplyServiceImpl extends ServiceImpl<FatherReplyMapper, FatherReply> implements FatherReplyService {

@Autowired
private FatherReplyMapper fatherReplyMapper;

    @Override
    public List<Map<String, Object>> selectReplyVoByPostId(Long postId) {
        List<Map<String, Object>> replyVo= fatherReplyMapper.selectReplyVoByPostId(postId);
        return replyVo;
    }
}
