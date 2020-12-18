package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/11 : 0:03
 */
@ApiModel("给前端返回数据的封装类")
public class ResponseMessageDTO implements Serializable {

    private static final long serialVersionUID = 4384805853552348226L;

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("状态描述信息")
    private String message;

    @ApiModelProperty("返回的数据")
    private Object data;

    public ResponseMessageDTO() {
    }

    public ResponseMessageDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseMessageDTO(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseMessageDTO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
