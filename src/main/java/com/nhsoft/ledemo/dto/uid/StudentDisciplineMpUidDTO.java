package com.nhsoft.ledemo.dto.uid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 */
@ApiModel("学生课程映射表联合主键封装表")
@Data
public class StudentDisciplineMpUidDTO implements Serializable {

    private static final long serialVersionUID = -1723507111394264256L;

    @ApiModelProperty("课程主键id")
    private Long disIdMp;

    @ApiModelProperty("学生主键id")
    private Long stuIdMp;

    @ApiModelProperty("学生学习课程年份")
    private String years;

    @ApiModelProperty("学生学习课程学期")
    private Short semester;

}
