package com.schoolwall.controller;


import com.schoolwall.common.lang.Result;
import com.schoolwall.entity.PostCategories;
import com.schoolwall.service.PostCategoriesService;
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
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/schoolwall")
public class PostCategoriesController {

    @Autowired
    PostCategoriesService postCategoriesService;


    @GetMapping("/categories")
    public Result listCategories(){

        List<PostCategories> postCategoriesList= postCategoriesService.selectCountPostByCategories();

        Result result= Result.succ(postCategoriesList);

        return result;

    }

}
