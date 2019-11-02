package com.hupan.springshiro.shiroConfig;

import com.hupan.springshiro.pojo.User;
import com.hupan.springshiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UserRealM
 * @Description TODO
 * @Author hupan
 * @Date 2019/10/30 14:36
 * @Version 1.0
 **/
public class UserRealm extends AuthorizingRealm {



    // 执行授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    @Autowired
    private UserService userService;

    // 执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String name = token.getUsername();


        User user = userService.selectUser(name);

        if (user==null)
            return null;
        // 判断用户名
        /*if (!token.getUsername().equals(name)) {
            return null;// shiro底层会抛出UnknownAccountException
        }*/
        // 判断密码(用AuthenticationInfo的子类)
        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}
