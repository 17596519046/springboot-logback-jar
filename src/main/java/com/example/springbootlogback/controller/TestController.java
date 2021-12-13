package com.example.springbootlogback.controller;

import com.example.springbootlogback.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/get")
    public String get(){
        return testService.get("aaa");
    }

}
