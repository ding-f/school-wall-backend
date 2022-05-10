package com.schoolwall.wxappfileserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WxappfileserverApplication {

    @RequestMapping("/")
    String Home(){
        return "AKU-WALL-PS";
    }

    public static void main(String[] args) {
        SpringApplication.run(WxappfileserverApplication.class, args);
    }

}
