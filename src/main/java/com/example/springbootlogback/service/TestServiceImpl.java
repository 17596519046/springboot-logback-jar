package com.example.springbootlogback.service;

import com.example.springbootlogback.mapper.TestMappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TestServiceImpl implements TestService{


    @Autowired
    TestMappers testMappers;


    @Override
    public String get(String arg) {
        List<Map> maps = testMappers.get();
        log.error("error !!!!");
        log.warn("warn ！！！！");
//        int i=1/0;
        return "567";
    }

}
