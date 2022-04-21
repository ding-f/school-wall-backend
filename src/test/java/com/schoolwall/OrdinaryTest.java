package com.schoolwall;


import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;


//@SpringBootTest
class OrdinaryTest {



    @Test
    void contextLoads() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);            //输出目录：/home/fuding/Desktop/schoolwall
    }

    @Test
    void md5Test(){
        String passwd = "school_wall_fuding";
        String passwdmd5 = SecureUtil.md5(passwd +"ding");
        System.out.println(passwdmd5);
    }


    @Test
    void timeTest(){
        System.out.println(System.currentTimeMillis());
        String date="Sun Apr 17 23:24:06 CST 2022";
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);

        System.out.println(df2.format(new Date()));
    }

    @Test
    void jwtTimeTest(){
        DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.FULL,Locale.CHINA);

        System.out.println("现在时间："+new Date().getTime()+"转换为本地时间格式："+dateFormat.format(new Date()));

        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNjUwMjEwMzQ1LCJleHAiOjE2NTA4MTUxNDV9.--YyJecr168sNJwmQyO0PdcOhGQwVDlpwSVvpjbu8XljVrHjnaNR11851segSynn_9LhhaWbCPZVtRoLvDzHDA
        String user2Claim1 = Base64.decodeStr("eyJzdWIiOiIyIiwiaWF0IjoxNjUwMjEwMzQ1LCJleHAiOjE2NTA4MTUxNDV9");
        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNjUwMjY0NDEyLCJleHAiOjE2NTA4NjkyMTJ9.nYBpqtPHIzB9egbAcEFwShRyNLwPeCqkd0j7kHrmTN3qhx2RTDFCMBREiOW9rJz_EYyaJFvWeNjwqoJ2P9sB0A
        String user2Claim2 = Base64.decodeStr("eyJzdWIiOiIyIiwiaWF0IjoxNjUwMjY0NDEyLCJleHAiOjE2NTA4NjkyMTJ9");


        String Header=Base64.decodeStr("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9");
        System.out.println(Header);

        System.out.println("------------------用户2第一次登录实验----------------");



        System.out.println("用户登录第一次后的JWT-Payload："+user2Claim1);


        //以下为了验证猜想：Jwt自己转换时间戳为秒
        long iat=1650210345;    //签发时间（秒）
        long exp=604800000/1000;    //有时间转换为秒

        long i=iat+exp;     //过期时间（秒）


        System.out.println("1650210345[签发时间戳] + "+"：604800[系统设置有效期时间戳（换算成秒）]"+i+"【过期时间戳】");


        String formatJwtDate1=formatJwtDate(iat,i);

        System.out.println(formatJwtDate1);


        System.out.println("------------------用户2第二次登录实验----------------");
        System.out.println("用户登录第二次后的JWT-Payload："+user2Claim2);

        String formatJwtDate2=formatJwtDate(1650264412,1650869212);

        System.out.println(formatJwtDate2);

        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjUwMzM3NzA0LCJleHAiOjE2NTA5NDI1MDR9.RNob5bTfOn84kaIRZLkSoUs-bMy4S6OY_Jh_WShPB2QzflLLRXqtywSoADgTqD0jPiKn1kTaoh-znBWOweg4Ww
        String user8Claim1=Base64.decodeStr("eyJzdWIiOiIxIiwiaWF0IjoxNjUwMzM3NzA0LCJleHAiOjE2NTA5NDI1MDR9");
        System.out.println("------------------用户1第一次登录实验----------------");
        System.out.println("用户登录第二次后的JWT-Payload："+user8Claim1);


    }

    public  String formatJwtDate(long iat,long exp){
        DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.FULL,Locale.CHINA);

        long iatms=iat*1000;
        long expms=exp*1000;

        String formatIatms= dateFormat.format(new Date(iatms));
        String formatExpms= dateFormat.format(new Date(expms));


        return "签证时间："+formatIatms+"\n过期时间:"+formatExpms;
    }
@Test
    void saveUser(){


}


    @Test
    void getOppenID() throws IOException {

        String code="093usFll2obI094SCLll26H2u52usFlo";
     final String APPID="wx770c13e4cb377da9";

   String appSecret="dc21a35567043302f013fb4f1d78c441";

    String wxURL="https://api.weixin.qq.com/sns/jscode2session" +
                "?appid=" + APPID +
                "&secret="+ appSecret +
                "&js_code=" + code +
                "&grant_type=authorization_code";


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(wxURL).build();

        Response response=client.newCall(request).execute();



        if(response.isSuccessful()){
            String body= Objects.requireNonNull(response.body()).string();
            System.out.println(body);
        }



    }
}
