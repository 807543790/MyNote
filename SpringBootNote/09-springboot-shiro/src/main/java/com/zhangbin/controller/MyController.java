package com.zhangbin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/10/28-12:23
 */
@Controller
public class MyController {


    @RequestMapping({"/index","/"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello,world");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add( ){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model) {

        Subject subject = SecurityUtils.getSubject();
//        创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);


//        执行登录方法
        try {
            subject.login(token); //登录成功，跳转首页
            return "index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在"); //登录失败，跳转登录页面
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码不存在"); //登录失败，跳转登录页面
            return "login";
        }

    }

}
