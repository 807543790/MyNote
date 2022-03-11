package com.zhangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/9/2-22:14
 */
@Controller
public class Hello {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","<h1>zhangbin</h1>");
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        model.addAttribute("users",list);
        return "test";
    }
}
