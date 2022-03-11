package com.zhangbin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/9/4-16:21
 */
//扩展springmvc
//    如果你想div一些定制化的功能,只要写这个组件,然后把它交给springboot,它会帮我们自动装配
@Configuration//@Configuration注解表示这是一个配置类，可以拓展其他属性
public class MyMvcConfig implements WebMvcConfigurer {

//    二：ViewResolver实现了视图解析器接口的类，我们将自定义的视图解析器加载到bean中
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    //一：自定义一个自己的视图解析器MyViewResolver
    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

//    视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/zhangbin").setViewName("test");
    }
}
