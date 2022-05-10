package com.jhzz.blog.controller;

import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/10
 * \* Time: 18:00
 * \* Description:
 * \
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    //    http://localhost:7777/comment/commentList?pageNum=1&pageSize=10&articleId=1
    @GetMapping("commentList")
    public ResponseResult findCommentList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "articleId") Long articleId) {

        return commentService.findCommentList(pageNum, pageSize, articleId);
    }

    //    http://localhost:7777/api/comment/linkCommentList?pageNum=1&pageSize=10&articleId=1
    @GetMapping("linkCommentList")
    public ResponseResult linkCommentList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "articleId") Long articleId) {

        return commentService.linkCommentList(pageNum, pageSize, articleId);
    }


}
