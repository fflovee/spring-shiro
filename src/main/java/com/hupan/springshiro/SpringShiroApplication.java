package com.hupan.springshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hupan.springshiro.dao")
public class SpringShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShiroApplication.class, args);
    }

}
