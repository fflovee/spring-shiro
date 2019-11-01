package com.hupan.springshiro.shiroConfig;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description shiro配置类
 * @Author hupan
 * @Date 2019/10/30 14:21
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {
    // 创建ShiroFilterFactorBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /* 添加shiro内置过滤器
         shiro内置过滤器,可以实现权限等相关的拦截器
         常用的过滤器:
         anon: 无需认证,(登录)可以访问
         authc: 必须认证才能访问
         user: 如果使用rememberMe的功能可以直接访问
         perms: 该资源必须得到资源权限才可以访问
         role: 该资源必须得到角色权限才可以访问*/
        Map<String,String> FilterMap = new LinkedHashMap<>();
        FilterMap.put("/add","authc");
        FilterMap.put("/update","authc");
        // 改为通配的方式
        FilterMap.put("/testThyme","anon");
        FilterMap.put("/login","anon");
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(FilterMap);
        return shiroFilterFactoryBean;
    }

    // 创建DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 创建Realm
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
}
