package com.schoolwall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.schoolwall.common.lang.ExpandResult;
import com.schoolwall.entity.Expand;
import com.schoolwall.service.ExpandService;
import com.schoolwall.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fuding
 * @since 2022-03-06
 * @API http://0.0.0.0:3000/schoolwall/options/homeconfig
 */
@RestController
@RequestMapping("/schoolwall")
public class ExpandController {
    @Autowired
    ExpandService expandService;

    String zanImageurl="https:\\/\\/ding-f.gitee.io\\/medias\\/reward\\/alipay_red.png";

    @GetMapping("/options/homeconfig")
    public ExpandResult list(){

        //查询轮播图
        QueryWrapper<Expand> expandQueryWrapperSwipe=new QueryWrapper<>();
        expandQueryWrapperSwipe.select().eq("select_swipe","swipe");
        List<Expand> swipeList=expandService.list(expandQueryWrapperSwipe);

        //查询功能模块
        QueryWrapper<Expand> expandQueryWrapperSelect=new QueryWrapper<>();
        expandQueryWrapperSelect.select().eq("select_swipe","select");
        List<Expand> selectList=expandService.list(expandQueryWrapperSelect);

        //设置数据到ExpandResult
        ExpandResult expandResult=new ExpandResult();
        expandResult.setZanImageurl(zanImageurl);
        expandResult.setSwipe_nav(swipeList);
        expandResult.setSelected_nav(selectList);

//        System.out.println(swipeList);

//        expandService.get
        return  expandResult;
    }


}
