package com.hupan.springshiro.service.serviceImpl;

import com.hupan.springshiro.dao.UserMapper;
import com.hupan.springshiro.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author hupan
 * @Date 2019/10/31 22:01
 * @Version 1.0
 **/
@Component
public class UserServiceImpl implements UserMapper {

    @Autowired
    UserMapper userMapper;


    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }
}
