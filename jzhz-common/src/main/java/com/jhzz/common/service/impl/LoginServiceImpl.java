package com.jhzz.common.service.impl;

import com.jhzz.common.config.JwtUtil;
import com.jhzz.common.config.RedisCache;
import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.domain.entity.LoginUser;
import com.jhzz.common.domain.enums.AppHttpCodeEnum;
import com.jhzz.common.domain.params.LoginParam;
import com.jhzz.common.domain.vo.UserInfoVo;
import com.jhzz.common.domain.vo.UserLoginVo;
import com.jhzz.common.excption.SystemException;
import com.jhzz.common.service.LoginService;
import com.jhzz.common.utils.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/10
 * \* Time: 21:13
 * \* Description:
 * \
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;
    @Override
    public ResponseResult login(LoginParam loginParam) {
        if (!StringUtils.hasText(loginParam.getPassword()) || !StringUtils.hasText(loginParam.getUsername())){
            throw new SystemException(AppHttpCodeEnum.LOGIN_ERROR.getCode(),"非法登录参数");
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken
                        (loginParam.getUsername(), loginParam.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        log.info("用户存在");
//        获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String token = JwtUtil.createJWT(userId);
        //把用户存入redis
        redisCache.setCacheObject("bloglogin:"+userId,loginUser);

        //把token和userinfo封装返回给前端
        UserInfoVo userInfoInfoVo = BeanCopyUtil.copyOne(loginUser.getUser(), UserInfoVo.class);
        UserLoginVo result = new UserLoginVo(token,userInfoInfoVo);

        return ResponseResult.okResult(result);
    }

    @Override
    public ResponseResult logout() {
        //获取token 解析获取userid
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //获取userid
        Long userId = loginUser.getUser().getId();
        //删除redis中的用户信息
        redisCache.deleteObject("bloglogin:"+userId);
        return ResponseResult.okResult();
    }
}
