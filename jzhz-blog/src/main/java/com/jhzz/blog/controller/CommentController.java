package com.jhzz.blog.controller;

import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.domain.entity.Comment;
import com.jhzz.common.domain.params.CommentDTO;
import com.jhzz.common.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@Api(tags = "CommentController", description = "评论相关的api")
public class CommentController {
    @Resource
    private CommentService commentService;

    //    http://localhost:7777/comment/commentList?pageNum=1&pageSize=10&articleId=1
    @GetMapping("commentList")
    @ApiOperation("获取文章对应评论")
    public ResponseResult findCommentList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "articleId") Long articleId) {

        return commentService.findCommentList(pageNum, pageSize, articleId);
    }

    //    http://localhost:7777/api/comment/linkCommentList?pageNum=1&pageSize=10&articleId=1
    @GetMapping("linkCommentList")
    @ApiOperation("获取友链对应评论")
    public ResponseResult linkCommentList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        return commentService.linkCommentList(pageNum, pageSize);
    }

    @PostMapping("add")
    public ResponseResult addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }


}
