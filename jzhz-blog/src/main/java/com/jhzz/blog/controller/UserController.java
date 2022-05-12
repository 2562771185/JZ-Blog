package com.jhzz.blog.controller;

import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.domain.entity.SysUser;
import com.jhzz.common.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/12
 * \* Time: 9:28
 * \* Description:
 * \
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Resource
    private SysUserService userService;

    @GetMapping("userInfo")
    public ResponseResult findUserInfo(@RequestParam("userId")Long userId){
        return userService.findUserInfo(userId);
    }
    //http://localhost:7777/api/user/userInfoUpdate
    @RequestMapping("userInfoUpdate")
    public ResponseResult userInfoUpdate(@RequestBody SysUser user){
        return userService.userInfoUpdate(user);
    }
}
