package com.jhzz.common.service;

import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.domain.params.LoginParam;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/10
 * \* Time: 21:13
 * \* Description:
 * \
 */
public interface LoginService {
    ResponseResult login(LoginParam loginParam);

    ResponseResult logout();

}
