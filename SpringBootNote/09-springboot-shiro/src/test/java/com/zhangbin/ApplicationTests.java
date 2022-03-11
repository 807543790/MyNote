package com.zhangbin;

import com.zhangbin.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    UserServiceImpl service;

    @Test
    void contextLoads() {
        System.out.println(service.queryUserByName("房贷"));
    }

}
