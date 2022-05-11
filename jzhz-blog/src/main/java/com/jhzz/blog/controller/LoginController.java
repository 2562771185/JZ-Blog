package com.jhzz.blog.controller;

import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.domain.params.LoginParam;
import com.jhzz.common.service.LoginService;
import com.jhzz.common.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/10
 * \* Time: 21:09
 * \* Description:
 * \
 */
@RestController
@CrossOrigin
@Api(tags = "LoginController")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseResult login(@RequestBody LoginParam loginParam) {
            return loginService.login(loginParam);
    }
    @PostMapping("/logout")
    @ApiOperation("注销")
    public ResponseResult logout(){
        return loginService.logout();
    }

}
