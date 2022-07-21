package com.schoolwall.wxappfileserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@EnableWebMvc
@RestController
@SpringBootApplication
public class WxappfileserverApplication {

    @RequestMapping("/")
    String Home(){
        return "AKU-WALL-FS";
    }
    public static void main(String[] args) {
        SpringApplication.run(WxappfileserverApplication.class, args);
    }

}
