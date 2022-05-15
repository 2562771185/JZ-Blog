package com.jhzz.common.service.impl;

import com.google.gson.Gson;
import com.jhzz.common.domain.ResponseResult;
import com.jhzz.common.domain.enums.AppHttpCodeEnum;
import com.jhzz.common.excption.SystemException;
import com.jhzz.common.service.UploadService;
import com.jhzz.common.utils.PathUtils;
import com.jhzz.common.utils.QiniuUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/14
 * \* Time: 0:39
 * \* Description:
 * \
 */
@Service
public class UploadServiceImpl implements UploadService {

//    @Autowired
//    QiniuUtils qiniuUtils;

    @Override
    public ResponseResult uploadImg(MultipartFile file) {

        //判断文件类型
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //对原始文件名进行判断
        if (!originalFilename.endsWith(".png") && !originalFilename.endsWith(".jpg")) {
            throw new SystemException(AppHttpCodeEnum.FILE_TYPE_ERROR);
        }

        //如果判断通过上传文件到OSS
        String filePath = PathUtils.generateFilePath(originalFilename);
        //  2099/2/3/wqeqeqe.png
        String url = uploadOss(file, filePath);
        return ResponseResult.okResult(url);

    }

    private String uploadOss(MultipartFile file, String filePath) {
//构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filePath;
        try {
            InputStream inputStream = file.getInputStream();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(inputStream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return "http://razk1ycbm.hn-bkt.clouddn.com/" + key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return "www";
    }


    @Value("${qiniu.accessKey}")
    private String accessKey;
    @Value("${qiniu.accessSecretKey}")
    private String secretKey;
    private String bucket = "jhzzblog";
//    public static  final String url = "http://razk1ycbm.hn-bkt.clouddn.com/";
//
//    private  String accessKey;
//    @Value("${qiniu.accessSecretKey}")
//    private  String accessSecretKey;
//
//    String bucket = "jhzzblog";
}
