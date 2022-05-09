package com.jhzz.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/8
 * \* Time: 12:38
 * \* Description:
 * \
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

}
