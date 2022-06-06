package com.schoolwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.schoolwall.common.dto.SubInfoDto;
import com.schoolwall.common.lang.Result;
import com.schoolwall.entity.PostCategories;
import com.schoolwall.entity.Posts;
import com.schoolwall.entity.UserSubscriptions;
import com.schoolwall.service.PostCategoriesService;
import com.schoolwall.service.PostsService;
import com.schoolwall.service.UserSubscriptionsService;
import com.schoolwall.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fuding
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/schoolwall")
public class PostCategoriesController {

    @Autowired
    PostCategoriesService postCategoriesService;
    @Autowired
    UserSubscriptionsService userSubscriptionsService;
    @Autowired
    PostsService postsService;


    //获取分类列表
    @GetMapping("/categories")
    public Result listCategories(){

        List<PostCategories> postCategoriesList= postCategoriesService.selectCountPostByCategories();
        return Result.succ(postCategoriesList);

    }

    //发布墙贴时获取分类列表
    @GetMapping("/addpostcategories")
    public Result listPostAddCate(){
        QueryWrapper<PostCategories> queryWrapper= new QueryWrapper<PostCategories>().select( "id","name","description");
        List<PostCategories> cateList=postCategoriesService.list(queryWrapper);
        Result result= Result.succ(cateList);
        return result;
    }

    //根据ID获取某个分类信息
    @GetMapping("/getcategorie/id={cid}")
    public PostCategories getCategorById(@PathVariable(name = "cid") Integer cid){

        return postCategoriesService.getById(cid);
    }

    //根据用户ID获取分类订阅ID
    @RequiresAuthentication
    @GetMapping("/getsubcategories/byuser")
    public Result getSubCateIdByUser(){
        //此用户订阅列表ID
        List<Integer> userSubList = new ArrayList<>();
        AccountProfile subUser=(AccountProfile) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Long userId = subUser.getId();
        //获得分类列表数组
        List<PostCategories> postCategoriesList= postCategoriesService.selectCountPostByCategories();
        QueryWrapper<UserSubscriptions> queryWrapper= new QueryWrapper<UserSubscriptions>().select("post_categories_id").eq("user_id",userId);
        List<UserSubscriptions> userSubedList = userSubscriptionsService.list(queryWrapper);
//        System.out.println(userSubedList);
        //取出用户已经订阅的ID放入数组
        for (UserSubscriptions userSub:userSubedList
             ) {

            userSubList.add(userSub.getPostCategoriesId());
//            System.out.println(userSub.getPostCategoriesId());

        }
//        System.out.println(userSubList);
        //遍历分类列表数组时取出分类ID与用户订阅的分类ID进行判断相等，相等设置订阅标签SubTab=1
        for (PostCategories postCategories :postCategoriesList
             ) {
            if (userSubList.contains(postCategories.getId())){
                postCategories.setSubTab(1);
//                System.out.println("包含："+postCategories.getId());

            }else {
                postCategories.setSubTab(0);
            }
        }

//        System.out.println(postCategoriesList);
        return Result.succ(postCategoriesList);
    }


    //增删订阅信息
    @RequiresAuthentication
    @PostMapping("/category/postsubscription")
    public Result delOrAddSub(@RequestBody SubInfoDto subInfoDto){
        AccountProfile subUser=(AccountProfile) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Long userId = subUser.getId();

        String openId=subInfoDto.getOpenId();
        Integer cateId=subInfoDto.getCategoryId();
        Integer subTab=subInfoDto.getSubTab();

        //已订阅
        if (subTab==1){

            //删除订阅表记录（取消订阅成功）
            QueryWrapper<UserSubscriptions> queryWrapper = new QueryWrapper<UserSubscriptions>().eq("user_id",userId).eq("post_categories_id",cateId);
            userSubscriptionsService.remove(queryWrapper);

            return Result.succ(200,"unsub");
        }
        //未订阅
        else{
            //向订阅表添加记录(成功订阅)
            UserSubscriptions userSubEntity=new UserSubscriptions();
            userSubEntity
                    .setUserId(userId)
                    .setPostCategoriesId(cateId)
                    .setUserOpenId(openId);

            userSubscriptionsService.save(userSubEntity);

            return Result.succ(200,"subed");

        }


    }


    //获取所有订阅墙贴列表
    @RequiresAuthentication
    @GetMapping("/category/getall/subscription")
    public Result getPostByCateId(){
        AccountProfile subUser=(AccountProfile) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Long userId = subUser.getId();

        List<Posts> list = userSubscriptionsService.userSubPosts(userId);

        return Result.succ(list);
    }

}
