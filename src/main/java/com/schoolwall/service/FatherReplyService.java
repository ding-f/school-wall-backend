package com.schoolwall.service;

import com.schoolwall.entity.FatherReply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.schoolwall.entity.vo.ReplyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fuding
 * @since 2022-03-21
 */
public interface FatherReplyService extends IService<FatherReply> {
    List<Map<String, Object>> selectReplyVoByPostId(@Param("post_id") Long postId);

}
