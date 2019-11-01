package com.hupan.springshiro.dao;

import com.hupan.springshiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

   User findByUserName(String username);

}
