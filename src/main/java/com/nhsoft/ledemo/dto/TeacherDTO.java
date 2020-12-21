package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hcsheng1998
 */
@ApiModel("老师表实体类")
@Data
public class TeacherDTO implements Serializable {

    private static final long serialVersionUID = 202736847978854016L;

    @ApiModelProperty("老师id,主键")
    private Long teaId;

    @ApiModelProperty("老师姓名")
    private String teaName;

    @ApiModelProperty("老师编号,唯一索引")
    private String teaNum;

}
