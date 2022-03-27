package com.schoolwall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.schoolwall.entity.FatherReply;
import com.schoolwall.mapper.FatherReplyMapper;
import com.schoolwall.service.FatherReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public IPage<Map<String, Object>> selectReplyVoByPostId(IPage<Map<String, Object>> page, Long postId) {
        IPage<Map<String, Object>> iPageFatherReply= fatherReplyMapper.selectReplyVoByPostId(page,postId);
        return iPageFatherReply;
    }


}
