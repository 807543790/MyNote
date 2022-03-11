# springBoot 2020-08-29

## 01- helloworld

## 02-yaml
  @ConfigurationProperties(prefix = "person")
  作用：
    将配置文件中的配置的每一个属性的值，映射到这个组件中告诉springboot
    将本类中所有的属性和配置文件中能拿个的相关配置进行绑定
    只有这个组件是容器中的组件，才能使用@ConfigurationProperties
    
   ```java
        /* @controller 控制器（注入服务）
        * 用于标注控制层，相当于struts中的action层
        *
        * @service 服务（注入dao）
        * 用于标注服务层，主要用来进行业务的逻辑处理
        *
        * @repository（实现dao访问）
        * 用于标注数据访问层，也可以说用于标注数据访问组件，即DAO组件
        *
        * @component 把普通pojo实例化到spring容器中，相当于配置文件中的 
``` 
数据校验：
```java
    @Validated//数据校验
    public class person {
    
        @Email(message = "邮箱不合法")
        private String name;
        private Integer age;
        private Boolean happy;
        private Date birthday;
        private Map<String,Object> maps;
        private List<Object> lists;
        private Dog dog;
```
要用spring-boot-starter-validation依赖
```xml
       <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-validation</artifactId>
            </dependency>
```

二：多环境的配置，和多个配置文件的优先级
    多个文件的配置优先级：
    1.项目下的config文件
    2.项目的配置文件
    3.resource下的config文件夹
    4.默认的配置文件
 
二点一：多环境配置：
   properties：
       定义多个以application开头的文件，然后在主文件使用spring.profiles.active=test定义选择要使用的配置文件
       
   yaml:
  ```yaml

    #yaml多环境配置,多个环境使用---区分

server:
  port: 8080

spring:
  profiles:
    active: dev
---

server:
  port: 8081
spring:
  profiles: test
---
server:
  port: 8082
spring:
  profiles: dev

```  
##03-web
   一：先导入依赖，将HTML文件放入templates文件夹
   ```xml
        <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-thymeleaf</artifactId>
                </dependency>
```         
   二：拓展springmvc,想自定义一些拦截器或者其他，只要实现WebMvcConfigurer接口
 ```java
    //扩展springmvc
    //    如果你想div一些定制化的功能,只要写这个组件,然后把它交给springboot,它会帮我们自动装配
    @Configuration
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
    
    }
``` 

##04-员工管理系统
1. 
    一：先导入依赖，将HTML文件放入templates文件夹
   ```xml
        <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-thymeleaf</artifactId>
                </dependency>
    ```         
   二：拓展springmvc,想自定义一些拦截器或者其他，只要实现WebMvcConfigurer接口
 ```java
    //扩展springmvc
    //    如果你想div一些定制化的功能,只要写这个组件,然后把它交给springboot,它会帮我们自动装配
    @Configuration
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
    
    }
``` 

2.前期的准备工作
    一：静态资源导入
```xml
    <!--导入<html xmlns:th="http://www.thymeleaf.org">依赖后，
        使用@{}引入css文件 
        -->
    <link th:href="@{css/bootstrap.min.css}" rel="stylesheet">
    
```   
 
3.国际化
    一：先定义i18n文件夹，创建中英文文件：
        ·login_en_US.properties
        ·login_zh_CN.properties
        ·login.properties
        在文件中定义号中英互译的文字
    二：在application.properties中绑定文件位置
         #我们配置的真实位置
         spring.messages.basename=i18n.login
    三：在页面的<a>标签中定义好跳转时携带的参数    
    ```html
        <a class="btn btn-sm" th:href="@{/index.html(lang='zh_CN')}">中文</a>
        <a class="btn btn-sm" th:href="@{/index.html(lang='en_US')}">English</a>
        <!--注意点-->
        <!--th:href="@{/index.html(lang='en_US')}"相当于/index.html?lang='en_US'-->
    ```    
    四：自定义MyLocaleResolver  
```java
    package com.zhangbin.config;
    
    import org.springframework.web.servlet.LocaleResolver;
    import org.thymeleaf.util.StringUtils;
    
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.util.Locale;
    
    /**
     * 认认真真敲代码，开开心心每一天
     *
     * @Date 2020/9/6-13:00
     */
    public class MylocaleResolver implements LocaleResolver {
        //解析请求
        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            //获取请求中的语言参数
            String language = request.getParameter("lang");
            //如果没有设置的，就执行默认的
            Locale locale = Locale.getDefault();
            //如果请求参数不为空，携带了国际化参数
            if(!StringUtils.isEmpty(language)){
                //zh_CN
                String[] split = language.split("_");
                //国家，地区
                locale  = new Locale(split[0], split[1]);
    
            }
    
            return locale;
        }
    
        @Override
        public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
    
        }
    }

```    
   五：在MyMvcConfig注册bean
```java    
        @Bean
        public LocaleResolver localeResolver(){
            return new MylocaleResolver();
        }
```   
4.登录功能实现
    一：在form表单中添加请求地址，注意URL使用@取值，注意最前方也要/符号
```html
<form class="form-signin" th:action="@{/user/login}" method="post">
```    
   二：登录页面的controller:loginController,注意重定向单词：redirect
```java
    package com.zhangbin.controller;
    
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.util.StringUtils;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    
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
                            Model model){
            if(!StringUtils.isEmpty(username) && "123456".equals(password)){
                System.out.println("成功");
                return "redirect:/main.html";
            }else {
                model.addAttribute("msg","用户名或者密码错误");
                System.out.println("失败");
                return "index";
            }
    
        }
    }

```   
   三：使用重定向需要在MyMvcConfig配置
```java
    //视图重定向跳转
    registry.addViewController("/main.html").setViewName("dashboard");
```
   四：添加用户名密码错误提醒
       注意th:if="${not #strings.isEmpty(msg)}"表示的是：如果msg不为空则显示标签数据
```html
    <!--如果msg为空显示提示-->
    			<p style="color:#ff1500;" th:text="${msg}" th:if="${not #strings.isEmpty(msg)}"></p>
```  
##5：拦截器判断登录是否可以进入主页面
   一：创建自定义拦截器LoginHandlerInterceptor实现HandlerInterceptor接口，重写preHandle方法
```java
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

```   
   二：在登录页面添加登录成功后给session传入值功能
```java
       session.setAttribute("loginUser",username);
```   
   三：重写拦截器方法，传入自定义拦截器
```java
    
    //重写拦截器，传入自定义的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
//                拦截的请求
                .addPathPatterns("/**")
//                不拦截的请求
                .excludePathPatterns("/index.html","/","/user/login","/static/**","/templates/*","/i18n/*","/css/*","/js/**","/img/**");
    }
```   
##6：员工列表展示
```html
<!DOCTYPE html>
<!-- saved from url=(0052)http://getbootstrap.com/docs/4.0/examples/dashboard/ -->

		<!--头部导航栏-->
		<div th:insert="~{commons/commons::topber}"></div>

		<div class="container-fluid">
			<div class="row">
				<!--侧边导航栏 (active='list.html')传递参数给组件 -->
				<div th:insert="~{commons/commons::sidebar(active='list.html')}"></div>

				<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
					<!--添加按钮-->
					<h2><a class="btn btn-sm btn-success" th:href="@{/emp}">添加员工</a></h2>

					<div class="table-responsive">
						<table class="table table-striped table-sm">
							<thead>
								<tr>
									<th>id</th>
									<th>lsatName</th>
									<th>email</th>
									<th>gender</th>
									<th>department</th>
									<th>birth</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody th:each="emp:${EmpList}">
								<td th:text="${emp.getId()}"></td>
								<td th:text="${emp.getLastName()}"></td>
								<td th:text="${emp.getEmail()}"></td>
								<td th:text="${emp.getGender() == 0? '女':'男'}"></td>
								<td th:text="${emp.getDepartment().getDepartment()}"></td>
								<td th:text="${ #dates.format(emp.getBirth(),'yyyy-MM-dd HH:mm:ss')}"></td>
								<td>
									<button class="btn btn-sm btn-primary">编辑</button>
									<button class="btn btn-sm btn-danger">删除</button>
								</td>
							</tbody>
						</table>
					</div>
				</main>
			</div>
		</div>

</html>
```
   定义模板：
         1,在模板标签中添加: th:fragment="sidebar"
         2,在页面中使用：
                <!--侧边导航栏  -->commons/commons文件夹目录，sidebar模板定义好的参数
         		<div th:insert="~{commons/commons::sidebar(active='list.html')}"></div>
    
###07-springSecurity认证，授权
1.导入包
```xml
   <!--security-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```
2、创建配置文件
```java
package com.zhangbin.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/10/22-16:30
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //一：授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    //链式编程
        http.authorizeRequests()
                //首页所有人可以访问
                .antMatchers("/").permitAll()
                //请求授权的规则
                .antMatchers("/level1/**").hasAnyRole("vip1")
                .antMatchers("/level2/**").hasAnyRole("vip2")
                .antMatchers("/level3/**").hasAnyRole("vip3");

//        没有权限就会默认跳到登录页面---loginPage("/toLogin")设置登录页面
        http.formLogin().loginPage("/toLogin")
//             usernameParameter("user").      设置自定义用户名，跟前端的name属性绑定
//             passwordParameter("pwd").       设置自定义用密码，跟前端的name属性绑定
//             loginProcessingUrl("/login");   设置自定义登录请求地址，跟前端name属性绑定-
                .usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login");
        //注销功能，logoutSuccessUrl：注销成功默认跳转首页
        http.logout().logoutSuccessUrl("/");

//        防止网站攻击
        http.csrf().disable();//关闭csrf功能，注销失败的原因

        //记住我功能，默认保存两周---rememberMeParameter("remember")绑定自定义记住我的功能
        http.rememberMe().rememberMeParameter("remember");
    }

//    二：认证

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内存认证inMemoryAuthentication
        auth.inMemoryAuthentication()

                //passwordEncoder密码编译
                .passwordEncoder(new BCryptPasswordEncoder())

                //创建用户zhangbin,密码为123456的用户，可访问vip2
                .withUser("zhangbin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2")
                .and()
                //创建用户root,密码为123456的用户，可访问，vip1，vip2，vip3
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3");
    }
}

```
###07-helloshiro
第一步：导入依赖
```xml
  <dependencies>
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-core</artifactId>
            <version>1.4.1</version>
        </dependency>

        <!-- configure logging -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>jcl-over-slf4j</artifactId>
            <version>1.7.21</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.21</version>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <scope>runtime</scope>
            <version>1.2.17</version>
        </dependency>
    </dependencies>

```
第二步：配置log4j和shiro.ini
```properties
#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
log4j.rootLogger=INFO, stdout
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d %p [%c] - %m %n
# General Apache libraries
log4j.logger.org.apache=WARN
# Spring
log4j.logger.org.springframework=WARN
# Default Shiro logging
log4j.logger.org.apache.shiro=INFO
# Disable verbose logging
log4j.logger.org.apache.shiro.util.ThreadContext=WARN
log4j.logger.org.apache.shiro.cache.ehcache.EhCache=WARN
```

```text
#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
# =============================================================================
# Quickstart INI Realm configuration
#
# For those that might not understand the references in this file, the
# definitions are all based on the classic Mel Brooks' film "Spaceballs". ;)
# =============================================================================

# -----------------------------------------------------------------------------
# Users and their assigned roles
#
# Each line conforms to the format defined in the
# org.apache.shiro.realm.text.TextConfigurationRealm#setUserDefinitions JavaDoc
# -----------------------------------------------------------------------------
[users]
# user 'root' with password 'secret' and the 'admin' role
root = secret, admin
# user 'guest' with the password 'guest' and the 'guest' role
guest = guest, guest
# user 'presidentskroob' with password '12345' ("That's the same combination on
# my luggage!!!" ;)), and role 'president'
presidentskroob = 12345, president
# user 'darkhelmet' with password 'ludicrousspeed' and roles 'darklord' and 'schwartz'
darkhelmet = ludicrousspeed, darklord, schwartz
# user 'lonestarr' with password 'vespa' and roles 'goodguy' and 'schwartz'
lonestarr = vespa, goodguy, schwartz

# -----------------------------------------------------------------------------
# Roles with assigned permissions
#
# Each line conforms to the format defined in the
# org.apache.shiro.realm.text.TextConfigurationRealm#setRoleDefinitions JavaDoc
# -----------------------------------------------------------------------------
[roles]
# 'admin' role has all permissions, indicated by the wildcard '*'
admin = *
# The 'schwartz' role can do anything (*) with any lightsaber:
schwartz = lightsaber:*
# The 'goodguy' role is allowed to 'drive' (action) the winnebago (type) with
# license plate 'eagle5' (instance specific id)
goodguy = winnebago:drive:eagle5
```

测试：
```java
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple Quickstart application showing how to use Shiro's API.
 *
 * @since 0.9 RC2
 */
public class Quickstart {

    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);


    public static void main(String[] args) {

        // The easiest way to create a Shiro SecurityManager with configured
        // realms, users, roles and permissions is to use the simple INI config.
        // We'll do that by using a factory that can ingest a .ini file and
        // return a SecurityManager instance:

        // Use the shiro.ini file at the root of the classpath
        // (file: and url: prefixes load from files and urls respectively):
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(iniRealm);

        // for this simple example quickstart, make the SecurityManager
        // accessible as a JVM singleton.  Most applications wouldn't do this
        // and instead rely on their container configuration or web.xml for
        // webapps.  That is outside the scope of this simple quickstart, so
        // we'll just do the bare minimum so you can continue to get a feel
        // for things.
        SecurityUtils.setSecurityManager(securityManager);

        // Now that a simple Shiro environment is set up, let's see what you can do:

        // get the currently executing user:

//        获取当前的用户对象
        Subject currentUser = SecurityUtils.getSubject();

        //        通过获取当前的用户对象，拿到session
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");

        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("session取了一个值[" + value + "]");
        }

//        判断当前的用户是否被认证
        if (!currentUser.isAuthenticated()) {

//          token：令牌
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
//            设置记住我
            token.setRememberMe(true);
            try {
                currentUser.login(token);//执行登录

                //用户名不存在
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                //密码不对
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                //用户名锁定
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            //认证异常
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:测试角色
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //test a typed permission (not instance-level) ：测试权限
        if (currentUser.isPermitted("lightsaber:wield")) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:测试是否拥有更高的权限
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
//        注销登录
        currentUser.logout();
        //结束
        System.exit(0);
    }
}
```