package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 23:36
 */
@ApiModel("课程表实体类")
@Data
public class DisciplineDTO extends PagingDTO implements Serializable {

    private static final long serialVersionUID = -6219660226965727690L;

    @ApiModelProperty("课程id,主键")
    private Long disId;

    @ApiModelProperty("课程名字")
    private String disName;

    @ApiModelProperty("课程编号,唯一索引")
    private String disNum;

}
