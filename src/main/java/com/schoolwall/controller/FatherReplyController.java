package com.schoolwall.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.schoolwall.common.dto.ReplyDto;
import com.schoolwall.common.lang.Result;
import com.schoolwall.entity.FatherReply;
import com.schoolwall.entity.SonReply;
import com.schoolwall.entity.User;
import com.schoolwall.service.FatherReplyService;
import com.schoolwall.service.SonReplyService;
import com.schoolwall.service.UserService;
import com.schoolwall.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fuding
 * @since 2022-03-21
 */
@RestController
@RequestMapping("/schoolwall")
public class FatherReplyController {
    @Autowired
    FatherReplyService fatherReplyService;
    @Autowired
    SonReplyService sonReplyService;
    @Autowired
    UserService userService;


    @RequiresAuthentication
    @GetMapping("/getcomments/postid={postid}/commentspage={commentspage}")
    public Result commentList(@PathVariable(name = "postid") Long postId, @PathVariable(name = "commentspage") Integer commentsPage) {
//        System.out.println("文章ID："+postId+"\n评论页面数："+commentsPage);

        Page<Map<String, Object>> dividePage = new Page(commentsPage, 5,true);

        IPage<Map<String, Object>> replyVo = fatherReplyService.selectReplyVoByPostId(dividePage, postId);


//        fatherReplyService.page();
//        System.out.println(user);

        Result result = Result.succ(replyVo);


//        System.out.println(replyVo);
        return result;
    }

    @RequiresAuthentication
    @PostMapping("comment/reply")
    public Result commentAdd(@RequestBody ReplyDto replyDto){
        AccountProfile commentUser=(AccountProfile)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        System.out.println(replyDto);
//        boolean saveSucc;
//        if(replyDto.getIsFatherReply()){
//            FatherReply fatherReply=new FatherReply();
//            fatherReply.setPostId(replyDto.getPostID());
//            fatherReply.setUserId(commentUser.getId());
//            fatherReply.setContent(replyDto.getContent());
//            fatherReply.setReceiverId(replyDto.getAuthorID());
//
//            saveSucc=fatherReplyService.save(fatherReply);
//
//        }else {
//            SonReply sonReply=new SonReply();
//            sonReply.setPostId(replyDto.getPostID());
//            sonReply.setFatherReplyId(replyDto.getParentID());
//            sonReply.setUserId(commentUser.getId());
//            sonReply.setContent(replyDto.getContent());
//            sonReply.setReceiverId(replyDto.getReceiverID());
//
//            saveSucc=sonReplyService.save(sonReply);
//        }

//        return Result.succ(saveSucc);
    return null;
    }

}
