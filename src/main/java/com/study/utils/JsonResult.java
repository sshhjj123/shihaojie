package com.study.utils;
public class JsonResult <T>{
    private Integer code;
    private String msg;
    private T data;

    public static JsonResult success(String msg) {
        JsonResult js = new JsonResult();
        js.setCode(200);
        js.setMsg(msg);
        return js;
    }

    public static <T> JsonResult success(T data, String msg) {
        JsonResult js = new JsonResult();
        js.setCode(200);
        js.setData(data);
        js.setMsg(msg);
        return js;
    }

    public static JsonResult fail(Integer code, String msg) {
        JsonResult js = new JsonResult();
        js.setCode(code);
        js.setMsg(msg);
        return js;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
