package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hcsheng1998
 */
@ApiModel("学生表实体类")
@Data
public class StudentDTO implements Serializable {

    private static final long serialVersionUID = -892961838308900105L;

    @ApiModelProperty("学生id,主键")
    private Long stuId;

    @ApiModelProperty("学生姓名")
    private String stuName;

    @ApiModelProperty("学生学号,唯一索引")
    private String stuNum;

}
