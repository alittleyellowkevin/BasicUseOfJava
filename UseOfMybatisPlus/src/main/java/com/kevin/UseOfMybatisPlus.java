package com.kevin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.kevin.mapper")
@SpringBootApplication
public class UseOfMybatisPlus {
    public static void main(String[] args) {
        SpringApplication.run(UseOfMybatisPlus.class, args);
    }
}
