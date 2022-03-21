package com.schoolwall;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchoolwallApplicationTests {

    @Test
    void contextLoads() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);            //输出目录：/home/fuding/Desktop/schoolwall
    }

}
