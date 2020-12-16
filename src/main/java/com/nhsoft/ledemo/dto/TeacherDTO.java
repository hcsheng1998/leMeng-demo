package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 19:44
 */
@ApiModel("老师表实体类")
@Data
public class TeacherDTO extends PagingDTO implements Serializable {

    @ApiModelProperty("老师id,主键")
    private Long teaId;

    @ApiModelProperty("老师姓名")
    private String teaName;

    @ApiModelProperty("老师编号,唯一索引")
    private String teaNum;

}
