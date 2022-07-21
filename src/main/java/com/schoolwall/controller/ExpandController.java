package com.schoolwall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.schoolwall.common.lang.ExpandResult;
import com.schoolwall.entity.Expand;
import com.schoolwall.service.ExpandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fuding
 * @API http://0.0.0.0:3000/schoolwall/options/homeconfig
 * @since 2022-03-06
 */


@Api(tags = "首页轮播图和精选内容APIs")
@RestController
@RequestMapping("/schoolwall")
public class ExpandController {
    @Autowired
    ExpandService expandService;

    String zanImageurl = "https:\\/\\/ding-f.gitee.io\\/medias\\/reward\\/alipay_red.png";

    @ApiOperation("首页轮播图精选内容数据获取")
    @GetMapping("/options/homeconfig")
    public ExpandResult list() {

        //查询轮播图
        QueryWrapper<Expand> expandQueryWrapperSwipe = new QueryWrapper<>();
        expandQueryWrapperSwipe.select().eq("select_swipe", "swipe");
        List<Expand> swipeList = expandService.list(expandQueryWrapperSwipe);

        //查询功能模块
        QueryWrapper<Expand> expandQueryWrapperSelect = new QueryWrapper<>();
        expandQueryWrapperSelect.select().eq("select_swipe", "select");
        List<Expand> selectList = expandService.list(expandQueryWrapperSelect);

        //设置数据到ExpandResult
        ExpandResult expandResult = new ExpandResult();
        expandResult.setZanImageurl(zanImageurl);
        expandResult.setSwipe_nav(swipeList);
        expandResult.setSelected_nav(selectList);

//        System.out.println(swipeList);

//        expandService.get
        return expandResult;
    }


}
