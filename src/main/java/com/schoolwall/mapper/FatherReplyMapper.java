package com.schoolwall.mapper;

import com.schoolwall.entity.FatherReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.schoolwall.entity.vo.ReplyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fuding
 * @since 2022-03-21
 */

@Component(value = "FatherReplyMapper")
public interface FatherReplyMapper extends BaseMapper<FatherReply> {

    List<Map<String, Object>> selectReplyVoByPostId(@Param("post_id") Long postID);

}
