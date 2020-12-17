package com.nhsoft.ledemo.util;


/**
 * @author heChangSheng
 * @date 2020/12/10 : 23:52
 */
public enum StatusCodeEnum {
    /**
     * 数据操作成功
     */
    SUCCESS(0, "数据操作成功"),
    /**
     * 数据请求失败
     */
    FAIL(1,"数据请求失败"),
    /**
     * 传输的数据异常
     */
    DATAEXCEPTION(3,"传输的数据异常");

    private int code;
    private String message;

    StatusCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "StatusCodeEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
