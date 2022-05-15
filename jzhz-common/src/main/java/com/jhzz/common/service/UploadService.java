package com.jhzz.common.service;

import com.jhzz.common.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/14
 * \* Time: 0:37
 * \* Description:
 * \
 */
public interface UploadService {

    ResponseResult uploadImg(MultipartFile file);
}
