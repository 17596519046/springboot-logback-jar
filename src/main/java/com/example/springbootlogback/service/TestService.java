package com.example.springbootlogback.service;

import com.example.springbootlogback.mapper.TestMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface TestService {

    String get(String arg);
}
