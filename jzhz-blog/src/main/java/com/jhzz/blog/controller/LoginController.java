package com.jhzz.blog.controller;

import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.domain.params.LoginParam;
import com.jhzz.common.service.LoginService;
import com.jhzz.common.service.SysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class LoginController {
    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public ResponseResult login(@RequestBody LoginParam loginParam) {
            return loginService.login(loginParam);
    }
    @PostMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }

}
