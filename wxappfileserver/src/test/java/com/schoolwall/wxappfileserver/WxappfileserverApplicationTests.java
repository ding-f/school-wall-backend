package com.schoolwall.wxappfileserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

//@SpringBootTest
class WxappfileserverApplicationTests {

    @Test
    void pathTest() {
        System.out.println(System.getProperty("user.home"));
//      //Users/fuding
        System.out.println(System.getProperty("user.dir"));
//        /Users/fuding/Desktop/school-wall-backend-master/wxappfileserver
        System.out.println(System.getProperty("user.dir")+ "/AKU-WALL-PS/");

    }
    @Test
    void dateTest(){
        System.out.println(new Date());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date= simpleDateFormat.format(new Date());
        System.out.println(date);
    }

}
