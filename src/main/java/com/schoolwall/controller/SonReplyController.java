package com.schoolwall.controller;


import com.schoolwall.common.dto.DelCommentDto;
import com.schoolwall.common.lang.Result;
import com.schoolwall.entity.FatherReply;
import com.schoolwall.entity.vo.UserReplyVo;
import com.schoolwall.mapper.SonReplyMapper;
import com.schoolwall.service.FatherReplyService;
import com.schoolwall.service.SonReplyService;
import com.schoolwall.shiro.AccountProfile;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fuding
 * @since 2022-03-21
 */

@RestController
@RequiredArgsConstructor        //Lombok 构造器注入（不加final会报错） 2022-06-08 https://mp.weixin.qq.com/s/L0Uh8bzQw589nR3TcwVuaw
@RequestMapping("/schoolwall")
public class SonReplyController {

    final SonReplyService sonReplyService;


    @RequiresAuthentication
    @GetMapping("/my/comments")
    public Result myReplys(){
        //获取已登录用户ID
        AccountProfile subUser=(AccountProfile) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Long userId = subUser.getId();
        List<UserReplyVo> list=sonReplyService.selectUserReplys(userId);

        return Result.succ(list);
    }


    final FatherReplyService fatherReply;
    final SonReplyService sonReply;

    @RequiresAuthentication
    @DeleteMapping("/delete/my/like")
    Result deleteMyComment(@RequestBody DelCommentDto delInfo){
        AccountProfile subUser=(AccountProfile) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();

        //此if的作用是，阻止登陆用户删除不属于自己的评论
        if(Objects.equals(subUser.getId(), delInfo.getUserId())) {
            if (delInfo.getFrom()) {
                // from 参数为true，执行删除子评论表数据
                sonReply.removeById(delInfo.getReplyId());

                return Result.succ(200,"已删除子级评论");

            } else {
                // from 参数为true，执行删除父评论表数据
                fatherReply.removeById(delInfo.getReplyId());
                return Result.succ(200,"已删除父级评论");
            }


        }
        return Result.fail("放弃吧，你没有操作权限！！");
    }
}
