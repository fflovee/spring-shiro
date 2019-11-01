package com.hupan.springshiro.service;

import com.hupan.springshiro.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author hupan
 * @Date 2019/10/31 21:57
 * @Version 1.0
 **/
@Component
public interface UserService {

    User selectUser(String username);

}
