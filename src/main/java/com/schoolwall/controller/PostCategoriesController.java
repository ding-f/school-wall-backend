package com.schoolwall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.schoolwall.common.lang.Result;
import com.schoolwall.entity.PostCategories;
import com.schoolwall.service.PostCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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


    //获取分类列表
    @GetMapping("/categories")
    public Result listCategories(){

        List<PostCategories> postCategoriesList= postCategoriesService.selectCountPostByCategories();

        Result result= Result.succ(postCategoriesList);

        return result;

    }

    //根据ID获取某个分类信息
    @GetMapping("getcategorie/id={cid}")
    public PostCategories getCategorById(@PathVariable(name = "cid") Integer cid){

        PostCategories postCategories= postCategoriesService.getById(cid);

        return postCategories;
    }



}
