package com.zhangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/9/2-22:09
 */
@Controller
public class hello {

    @RequestMapping("hello")
    public String helloworld(){
       return "test";
    }
}
