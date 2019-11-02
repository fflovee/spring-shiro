package com.hupan.springshiro.service.serviceImpl;

import com.hupan.springshiro.dao.UserMapper;
import com.hupan.springshiro.pojo.User;
import com.hupan.springshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description ServiceImpl
 * @Author hupan
 * @Date 2019/10/31 22:01
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUser(String username) {
        return userMapper.findByUserName(username);
    }
}
