package com.schoolwall.common.lang;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/2/19 9:00 AM
 */

@Data
@Accessors(chain = true)
public class Result implements Serializable {
    private int code;
    private  String msg;
    private  Object data;

    public static Result succ(int code, String msg, Object data) {      //自定义（返回码，消息，数据）
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static Result succ(Object data) {        //只设置Data
        return succ(200, "操作成功", data);
    }




    public static Result fail(int code, String msg, Object data) {      //自定义（返回码，消息，数据）
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static Result fail(String msg) {     //自定义消息，无数据
        return fail(400, msg, null);
    }
    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }       //自定义错误返回（消息，数据）

}
