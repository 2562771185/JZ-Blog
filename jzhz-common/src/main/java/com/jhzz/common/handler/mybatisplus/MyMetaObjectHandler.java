package com.jhzz.common.handler.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jhzz.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Huanzhi
 * mybatis-plus 自动填充属性配置
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = null;

        try {
            userId = SecurityUtils.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("没有登录就想评论？");
            //表示是自己创建
            userId = -1L;
        }
        if (userId != null) {
            this.setFieldValByName("createBy",userId , metaObject);
            this.setFieldValByName("updateTime", new Date(), metaObject);
            this.setFieldValByName("createTime", new Date(), metaObject);
            this.setFieldValByName("updateBy", userId, metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName(" ", SecurityUtils.getUserId(), metaObject);
    }
}