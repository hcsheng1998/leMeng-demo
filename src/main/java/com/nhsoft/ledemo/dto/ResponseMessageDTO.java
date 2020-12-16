package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/11 : 0:03
 */
@ApiModel("给前端返回数据的封装类")
@Data
@Accessors(chain = true)
public class ResponseMessageDTO implements Serializable {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("状态描述信息")
    private String message;

    @ApiModelProperty("返回的数据")
    private Object data;
}
