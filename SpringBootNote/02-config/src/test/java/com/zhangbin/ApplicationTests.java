package com.zhangbin;

import com.zhangbin.pojo.Dog;
import com.zhangbin.pojo.person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Dog dog;

    @Autowired
    private person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }


}
