package com.zhangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/9/6-13:32
 */
//登录页面controller
@Controller
public class loginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                        Model model,
                        HttpSession session

    ){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            System.out.println("成功");
            //登录成功，传入session
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或者密码错误");
            System.out.println("失败");
            return "index";
        }

    }

    //注销功能
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        //清除session
        session.invalidate();
        return "redirect:/index.html";
    }
}
