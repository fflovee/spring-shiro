package com.hupan.springshiro.controller;

import com.hupan.springshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloController
 * @Description HelloController
 * @Author hupan
 * @Date 2019/10/30 13:20
 * @Version 1.0
 **/
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    // 测试thymeleaf
    @GetMapping("/testThyme")
    public String testThyme(Model model) {
        model.addAttribute("name", "胡畔");
        return "test";
    }

    @GetMapping("/add")
    public String add() {
        return "/user/add";
    }

    @GetMapping("/update")
    public String update() {
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/user/login";
    }

    @PostMapping("/login")
    public String login(String name, String password, Model model) {
        // 使用shiro编写认证插件
        System.out.println("名字:"+name+"密码:"+password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);
            model.addAttribute("/testThyme");
            return "test";
            // 登录成功
        } catch (UnknownAccountException e) {
            // 用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "/user/login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "用户密码错误");
            return "/user/login";
        }
    }

}
