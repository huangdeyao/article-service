package com.dy.feignservice.result;

public enum RespCode {

    SUCCESS(0, "请求成功"),
    SAVED(1, "已保存过"),
    WARN(-1, "网络异常，请稍后重试"),
    SAVEFAILE(3, "保存失败"),
    EMPTY(2,"数据为空");

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
        this.code=code;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}