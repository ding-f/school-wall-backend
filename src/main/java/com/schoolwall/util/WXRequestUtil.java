package com.schoolwall.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.Objects;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/4/20 19:46
 */
public class WXRequestUtil {

    private final String APPID="wx770c13e4cb377da9";
    private String appSecret="dc21a35567043302f013fb4f1d78c441";

    public String getOppenID(String code) throws IOException {

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


        return null;
    }
}
