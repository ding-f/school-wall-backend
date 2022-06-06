package com.schoolwall.controller;


import com.schoolwall.common.lang.Result;
import com.schoolwall.entity.vo.UserReplyVo;
import com.schoolwall.mapper.SonReplyMapper;
import com.schoolwall.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fuding
 * @since 2022-03-21
 */

@RestController
@RequestMapping("/schoolwall")
public class SonReplyController {

    @Autowired
    SonReplyMapper sonReplyMapper;

    @RequiresAuthentication
    @GetMapping("/my/comments")
    public Result myReplys(){
        //获取已登录用户ID
        AccountProfile subUser=(AccountProfile) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Long userId = subUser.getId();
        List<UserReplyVo> list=sonReplyMapper.selectUserReplys(userId);

        return Result.succ(list);
    }
}
