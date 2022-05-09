package com.jhzz.blog.controller;

import com.jhzz.common.entity.Article;
import com.jhzz.common.entity.params.CommonResult;
import com.jhzz.common.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/9
 * \* Time: 13:12
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @RequestMapping("/findAll")
    public CommonResult findAllArticles(){
        List<Article> list = articleService.list();
        return CommonResult.success(list);
    }
}
