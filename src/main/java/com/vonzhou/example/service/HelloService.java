package com.vonzhou.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @version 2018/4/18.
 */
@Service
public class HelloService {

    @Value("${spring.workspace.baseDir}")
    private String baseDir;

    @Autowired
    private Environment environment;

    public void hello() {
        System.out.println(environment.getProperty("spring.datasource.url"));
        System.out.println(baseDir);
    }
}
