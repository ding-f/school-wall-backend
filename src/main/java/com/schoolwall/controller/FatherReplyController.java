package com.schoolwall.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.schoolwall.common.lang.Result;
import com.schoolwall.service.FatherReplyService;
import com.schoolwall.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    UserService userService;


    @RequiresAuthentication
    @GetMapping("/getcomments/postid={postid}/commentspage={commentspage}")
    public Result commentList(@PathVariable(name = "postid") Long postId, @PathVariable(name = "commentspage") Integer commentsPage) {
//        System.out.println("文章ID："+postId+"\n评论页面数："+commentsPage);

        Page<Map<String, Object>> dividePage = new Page(commentsPage, 5, false);

        IPage<Map<String, Object>> replyVo = fatherReplyService.selectReplyVoByPostId(dividePage, postId);


//        fatherReplyService.page();


        Result result = Result.succ(replyVo);


//        System.out.println(replyVo);
        return result;
    }

}
