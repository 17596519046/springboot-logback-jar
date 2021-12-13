package com.example.springbootlogback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/****
 * springboot项目启动，放在tomcat服务器下面启动，修改启动类
 */
@SpringBootApplication
@MapperScan(value = "com.example.springbootlogback.mapper")
public class BokeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BokeApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BokeApplication.class);
    }
}
