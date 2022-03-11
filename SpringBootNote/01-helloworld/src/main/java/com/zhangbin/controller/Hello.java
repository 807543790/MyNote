package com.zhangbin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/31-19:53
 */
@RestController
public class Hello {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
