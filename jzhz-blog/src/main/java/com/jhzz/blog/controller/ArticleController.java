package com.jhzz.blog.controller;

import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.domain.entity.Article;
import com.jhzz.common.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "ArticleController", description = "文章相关的api")
@CrossOrigin
public class ArticleController {
    @Resource
    private ArticleService articleService;

    //http://localhost:7777/api/article/articleList?pageNum=1&pageSize=5&categoryId=1
    @GetMapping("/articleList")
    @ApiOperation("获取文章列表")
    public ResponseResult findAllArticles(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "categoryId", required = false, defaultValue = "0") Long categoryId) {

        return articleService.findAllArticles(pageNum, pageSize, categoryId);
    }

    //hotArticleList
    @GetMapping("/hotArticleList")
    @ApiOperation("获取热门文章")
    public ResponseResult hotArticleList() {
        return articleService.hotArticleList();
    }

    //http://localhost:7777/api/article/1
    @GetMapping("/{id}")
    @ApiOperation("获取文章详情")
    public ResponseResult detailArticle(@PathVariable Long id) {
        return articleService.findArticleDetailById(id);
    }

    //    http://localhost:7777/api/article/updateViewCount/1

    /**
     * 更新阅读数
     */
    @PutMapping("updateViewCount/{id}")
    @ApiOperation("更新文章阅读数")
    public ResponseResult updateViewCount(@PathVariable Long id) {
        return articleService.updateViewCount(id);
    }

}
