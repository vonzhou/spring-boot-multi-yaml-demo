package com.vonzhou.example.service;

import com.vonzhou.example.TestContext;
import com.vonzhou.example.config.YamlFileApplicationContextInitializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 2018/4/18.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestContext.class, initializers = YamlFileApplicationContextInitializer.class)
@ActiveProfiles("dev")
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void hello() {
        helloService.hello();
    }
}
