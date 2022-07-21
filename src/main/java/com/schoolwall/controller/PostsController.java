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
import com.schoolwall.shiro.AccountProfile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
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

@Api(tags = "帖子信息处理APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("/schoolwall")
public class PostsController {


    final PostsService postsService;
//    @Autowired
//    ImagesService imagesService;
    final UserService userService;

    //分页查询墙贴列表
    @ApiOperation(value = "分页查询墙贴列表")
    @GetMapping("/posts/page={page}")
    public IPage postList(@ApiParam(value = "页数", example = "1", required = true, name = "page") @PathVariable(name = "page") Integer page) {

        Page dividePage = new Page(page, 10,false);     //false 代表不进行全部列表的条目统计，即只进行了数据库内部进行分页操作，如果不定义就会查询所有条目并统计所有条目数目
        QueryWrapper<Posts> queryWrapper = new QueryWrapper<Posts>()
                .select("id","title", "post_image0", "date", "total_comments", "like_count", "pageviews")
                .orderByDesc("date");
        //QueryWrapper<Blog>查询出来后应该是全部的Blog列表然后进行一个排序，利用page进行分页操作。
        IPage pageData = postsService.page(dividePage, queryWrapper);

        return pageData;
    }

    //根据墙贴ID查询墙贴详细信息
    @ApiOperation(value = "根据墙贴ID查询墙贴详细信息")
    @GetMapping("getpostinfo/id={id}")
    public Result postInfo(@ApiParam(value = "墙贴ID", example = "100", required = true, name = "id") @PathVariable(name = "id") Long id){
       Posts p=postsService.getPostAllInfo(id);
        return Result.succ(p);
    }

    //查询帖子详细信息
//    @GetMapping("getpost/id={id}")
//    public Posts postDetail(@PathVariable(name = "id") Long id) {
//        Posts post = postsService.getById(id);
//
//        //查询某文章所有的图片
////        QueryWrapper<Images> imagesQueryWrapper = new QueryWrapper<Images>().select().eq("post_id", id);
////        List postImages = imagesService.list(imagesQueryWrapper);
////        post.setPostAllImages(postImages);
//
//        //查询某文章点赞用户头像
//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>()
//                .select("avatar_url")
//                .inSql("id", "select user_id from sw_like where post_id = " + id);
//
//        List avatarUrlsList = userService.list(userQueryWrapper);
//        post.setAvatarUrls(avatarUrlsList);
//
//        return post;
//    }

    //根据分类ID获取该ID下的所有文章
    @ApiOperation(value = "根据分类ID获取该ID下的所有文章")
    @GetMapping("/posts/page={page}/categorieid={cid}")
    public IPage<Posts> postListByCategorieId(@ApiParam(name = "page", required = true, value = "某个分类列表的页数", example = "1") @PathVariable(name = "page") Integer pageNum ,
                                              @ApiParam(name = "cid",required = true, example = "2",value = "分类ID号") @PathVariable(name = "cid") Integer cateId){

        Page page = new Page(pageNum,10,false);

        QueryWrapper<Posts> queryWrapper= new QueryWrapper<Posts>().select("id","title", "post_image0", "date", "total_comments", "like_count", "pageviews")
                .orderByDesc("date")
                .eq("category_id",cateId);

//        List postList= postsService.list(queryWrapper);

        IPage<Posts> pageData = postsService.page(page,queryWrapper);

        return pageData;
    }

    //根据关键字搜索含有关键字的标题或文章
    @ApiOperation(value = "根据关键字搜索含有关键字的标题或文章")
    @GetMapping("/posts/page={pagenum}/search={keyword}")
    public IPage<Posts> searchPosts(@ApiParam(name = "pagenum", required = true, example = "1", value = "搜索列表页数") @PathVariable("pagenum") Integer pageNum,
                                    @ApiParam(name = "keyword", required = true, example = "伞", value = "搜索关键词") @PathVariable("keyword") String keyWord) {
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

    //墙贴发布或更改
    @ApiOperation(value = "墙贴信息发布")
    @RequiresAuthentication
    @PostMapping("/postaddorup")
    public Result addOrUpdatePost(@RequestBody PostInfoDto postInfo){
        System.out.println(postInfo.toString());
        //获得登录用户Principal
        AccountProfile commentUser=(AccountProfile) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Posts post=new Posts();
        BeanUtil.copyProperties(postInfo,post);
        post.setUserId(commentUser.getId());
        boolean out = postsService.saveOrUpdate(post);

        return Result.succ(out);
    }

}
