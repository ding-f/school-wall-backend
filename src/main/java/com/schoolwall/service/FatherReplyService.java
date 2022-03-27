package com.schoolwall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.schoolwall.entity.FatherReply;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

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
    IPage<Map<String, Object>> selectReplyVoByPostId(IPage<Map<String, Object>> page,@Param("post_id") Long postId);

}
