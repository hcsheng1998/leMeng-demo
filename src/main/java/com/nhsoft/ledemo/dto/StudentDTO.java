package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:16
 */
@ApiModel("学生表实体类")
@Data
public class StudentDTO extends PagingDTO implements Serializable {

    @ApiModelProperty("学生id,主键")
    private Long stuId;

    @ApiModelProperty("学生姓名")
    private String stuName;

    @ApiModelProperty("学生学号,唯一索引")
    private String stuNum;

}
