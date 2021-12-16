package com.example.springbootlogback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.springbootlogback.mapper")
@SpringBootApplication
public class SpringbootLogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLogbackApplication.class, args);
    }

}
