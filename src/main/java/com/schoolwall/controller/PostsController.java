package com.schoolwall.controller;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.schoolwall.entity.Images;
import com.schoolwall.entity.Like;
import com.schoolwall.entity.Posts;
import com.schoolwall.entity.User;
import com.schoolwall.service.ImagesService;
import com.schoolwall.service.LikeService;
import com.schoolwall.service.PostsService;
import com.schoolwall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fuding
 * @since 2022-03-10
 */
@RestController
@RequestMapping("/schoolwall")
public class PostsController {

    @Autowired
    PostsService postsService;
    @Autowired
    ImagesService imagesService;
    @Autowired
    UserService userService;

    //查询帖子分页列表
    @GetMapping("/posts/page={page}")
    public IPage list(@PathVariable(name = "page") Integer page) {

        Page dividePage = new Page(page, 10);
        QueryWrapper queryWrapper = new QueryWrapper<Posts>().select("id","title", "post_medium_image", "date", "total_comments", "like_count", "pageviews").orderByDesc("date");
        //QueryWrapper<Blog>查询出来后应该是全部的Blog列表然后进行一个排序，利用page进行分页操作。
        IPage pageData = postsService.page(dividePage, queryWrapper);

        return pageData;
    }

    //查询帖子详细信息
    @GetMapping("getpost/id={id}")
    public Posts postDetail(@PathVariable(name = "id") Integer id) {
        Posts post = postsService.getById(id);

        //查询某文章所有的图片
        QueryWrapper<Images> imagesQueryWrapper = new QueryWrapper<Images>().select().eq("post_id", id);
        List postImages = imagesService.list(imagesQueryWrapper);
        post.setPostAllImages(postImages);

        //查询某文章点赞用户头像
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>().select("avatar_url").inSql("id", "select user_id from sw_like where post_id = " + id);
        List avatarUrlsList = userService.list(userQueryWrapper);
        post.setAvatarUrls(avatarUrlsList);

        return post;
    }

}
