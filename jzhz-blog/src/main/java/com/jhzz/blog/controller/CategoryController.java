package com.jhzz.blog.controller;

import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/9
 * \* Time: 22:52
 * \* Description:
 * \
 */
@RestController
@RequestMapping("category")
@CrossOrigin
@Api(tags = "CategoryController", description = "文章分类相关的api")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

//    http://localhost:7777/api/category/getCategoryList
    @GetMapping("getCategoryList")
    @ApiOperation("获取文章分类列表")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }
}
