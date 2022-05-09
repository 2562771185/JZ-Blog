package com.jhzz.blog.controller;

import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@CrossOrigin
public class ArticleController {
    @Resource
    private ArticleService articleService;

    //http://localhost:7777/api/article/articleList?pageNum=1&pageSize=5&categoryId=1
    @GetMapping("/articleList")
    public ResponseResult findAllArticles(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("categoryId") Long categoryId) {

        return articleService.findAllArticles(pageNum,pageSize,categoryId);
    }

    //hotArticleList
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {
        return articleService.hotArticleList();
    }


}
