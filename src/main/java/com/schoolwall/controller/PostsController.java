package com.schoolwall.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.schoolwall.common.dto.PostInfoDto;
import com.schoolwall.common.dto.ReplyDto;
import com.schoolwall.common.lang.Result;
import com.schoolwall.entity.Images;
import com.schoolwall.entity.Posts;
import com.schoolwall.entity.User;
import com.schoolwall.service.ImagesService;
import com.schoolwall.service.PostsService;
import com.schoolwall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//    @Autowired
//    ImagesService imagesService;
    @Autowired
    UserService userService;

    //查询帖子分页列表
    @GetMapping("/posts/page={page}")
    public IPage postList(@PathVariable(name = "page") Integer page) {

        Page dividePage = new Page(page, 10,false);     //false 代表不进行全部列表的条目统计，即只进行了数据库内部进行分页操作，如果不定义就会查询所有条目并统计所有条目数目
        QueryWrapper<Posts> queryWrapper = new QueryWrapper<Posts>()
                .select("id","title", "post_image0", "date", "total_comments", "like_count", "pageviews")
                .orderByDesc("date");
        //QueryWrapper<Blog>查询出来后应该是全部的Blog列表然后进行一个排序，利用page进行分页操作。
        IPage pageData = postsService.page(dividePage, queryWrapper);

        return pageData;
    }

    //查询帖子详细信息
    @GetMapping("getpost/id={id}")
    public Posts postDetail(@PathVariable(name = "id") Long id) {
        Posts post = postsService.getById(id);

        //查询某文章所有的图片
//        QueryWrapper<Images> imagesQueryWrapper = new QueryWrapper<Images>().select().eq("post_id", id);
//        List postImages = imagesService.list(imagesQueryWrapper);
//        post.setPostAllImages(postImages);

        //查询某文章点赞用户头像
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>()
                .select("avatar_url")
                .inSql("id", "select user_id from sw_like where post_id = " + id);

        List avatarUrlsList = userService.list(userQueryWrapper);
        post.setAvatarUrls(avatarUrlsList);

        return post;
    }

    //根据分类ID获取该ID下的所有文章
    @GetMapping("/posts/page={page}/categorieid={cid}")
    public IPage<Posts> postListByCategorieId(@PathVariable(name = "page") Integer pageNum ,@PathVariable(name = "cid") Integer cateId){

        QueryWrapper<Posts> queryWrapper= new QueryWrapper<Posts>().select("id","title", "post_image0", "date", "total_comments", "like_count", "pageviews")
                .eq("category_id",cateId);

//        List postList= postsService.list(queryWrapper);

        Page page = new Page(pageNum,10,false);

        IPage<Posts> pageData = postsService.page(page,queryWrapper);

        return pageData;
    }

    //根据关键字搜索含有关键字的标题或文章
    @GetMapping("/posts/page={pagenum}/search={keyword}")
    public IPage<Posts> searchPosts(@PathVariable("pagenum") Integer pageNum,@PathVariable("keyword") String keyWord) {
        QueryWrapper<Posts> queryWrapper =new QueryWrapper<Posts>()
                .select("id","title", "post_image0", "date", "total_comments", "like_count", "pageviews")
                .like("content",keyWord)
                .or()
                .like("title",keyWord);

        Page page = new Page(pageNum, 10,false);

        IPage<Posts> searchPostsPage= postsService.page(page,queryWrapper);

//        System.out.println("当前页面："+ pageNum+"-------------搜索关键字："+keyWord);

        return searchPostsPage;
    }

    //
    @PostMapping("/postaddorup")
    public Result addOrUpdatePost(@RequestBody PostInfoDto postInfo){
        System.out.println(postInfo.toString());
        Posts post=new Posts();
        BeanUtil.copyProperties(postInfo,post);
        boolean out = postsService.saveOrUpdate(post);

        return Result.succ(out);
    }

}
