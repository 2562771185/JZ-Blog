package com.jhzz.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/8
 * \* Time: 12:00
 * \* Description:
 * \
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.jhzz.common.*","com.jhzz.blog.*"})
@MapperScan(basePackages = {"com.jhzz.common.mapper","com.jhzz.blog.mapper"})
public class JzhzBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(JzhzBlogApplication.class, args);
    }
}
