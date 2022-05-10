package com.jhzz.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Huanzhi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVo {

    private String token;
    private UserInfoVo userInfo;
}