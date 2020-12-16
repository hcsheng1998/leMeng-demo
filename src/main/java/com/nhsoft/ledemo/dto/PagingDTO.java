package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 16:54
 */
@ApiModel("分页数据父类")
@Data
public class PagingDTO {

    @ApiModelProperty(value = "分页数据起始位置",example = "0")
    public int page = 0;

    @ApiModelProperty(value = "每页分成多少个",example = "5")
    public int size = 5;

}