package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hcsheng1998
 */
@ApiModel("给前端返回数据的封装类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessageDTO implements Serializable {

    private static final long serialVersionUID = 4384805853552348226L;

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("状态描述信息")
    private String message;

    @ApiModelProperty("返回的数据")
    private Object data;

    public ResponseMessageDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
