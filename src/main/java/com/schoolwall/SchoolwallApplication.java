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
        return "AKU-WALL-BE";
    }
    public static void main(String[] args) {
        SpringApplication.run(SchoolwallApplication.class, args);
    }

}
