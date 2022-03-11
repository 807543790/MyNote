package com.zhangbin.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/9/6-15:00
 */
//拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否登录成功，成功session不为空
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            request.setAttribute("msg","没有权限，请登录");
//            登录成功请求转发，携带request和response
            request.getRequestDispatcher("/index.html").forward(request,response);
        }
            return true;

    }
}
