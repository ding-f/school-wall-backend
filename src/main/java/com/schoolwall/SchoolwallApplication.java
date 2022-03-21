package com.schoolwall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SchoolwallApplication {

    @RequestMapping("/")
    String Home(){
        return "安康学院校园墙";
    }
    public static void main(String[] args) {
        SpringApplication.run(SchoolwallApplication.class, args);
    }

}
