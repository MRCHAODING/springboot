package com.atdc.springboottest;

import com.atdc.springboottest.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringboottestApplicationTests {

    @Test
    void contextLoads() {
        Department department = new Department();
        System.out.println(department);
    }

}
