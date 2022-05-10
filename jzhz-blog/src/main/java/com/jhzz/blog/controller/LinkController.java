package com.jhzz.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jhzz.common.constants.SystemConstants;
import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.domain.entity.Link;
import com.jhzz.common.domain.vo.LinkVo;
import com.jhzz.common.service.LinkService;
import com.jhzz.common.utils.BeanCopyUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/10
 * \* Time: 15:50
 * \* Description:
 * \
 */
@RestController
@RequestMapping("link")
public class LinkController {
    @Resource
    private LinkService linkService;

//    /link/getAllLink
    @GetMapping("getAllLink")
    public ResponseResult getAllLink(){
        //查询所有审核通过的
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);

        List<Link> links = linkService.list(queryWrapper);
        return ResponseResult.okResult(BeanCopyUtil.copyList(links, LinkVo.class));
    }
}
