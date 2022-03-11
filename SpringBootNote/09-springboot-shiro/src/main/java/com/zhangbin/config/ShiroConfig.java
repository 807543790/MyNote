package com.zhangbin.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/10/28-12:33
 */
//配置类需要的注解
@Configuration
public class ShiroConfig {

//    @Autowired默认按照类型匹配注入bean，如果有多个实现类，搭配@Qualifier(“实现类名称”)表明注入的是哪一个实现类的bean：
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//        设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

//        添加shiro的内置过滤器
        /*
        * anon:无需认证就可以访问
        * authc:必须认证才能访问
        * user：必须拥有记住我功能才能使用
        * perms:拥有对某个资源的权限才能访问
        * role：拥有某个角色权限才能访问
        * */

        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        //支持通配符
        filterMap.put("user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录页面
        bean.setLoginUrl("/toLogin");
        return bean;
    }

    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

//    创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
