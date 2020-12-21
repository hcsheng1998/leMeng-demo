package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hcsheng1998
 */
@ApiModel("分页数据")
@Data
public class PagingDTO implements Serializable {

    private static final long serialVersionUID = 9107353203645156826L;

    @ApiModelProperty(value = "分页数据起始位置",example = "0")
    public int offset = 0;

    @ApiModelProperty(value = "每页分成多少个",example = "5")
    public int rows = 5;

}
