package com.nhsoft.ledemo.dto;

import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author hcsheng1998
 */
@ApiModel("老师课程映射表实体类")
@Data
public class TeacherDisciplineMappingDTO implements Serializable {

    private static final long serialVersionUID = 5967761442169086198L;

    @ApiModelProperty("老师,课程联合主键封装类对象")
    private TeacherDisciplineMpUidDTO teacherDisciplineMpUid = new TeacherDisciplineMpUidDTO();

    @ApiModelProperty("老师类")
    private TeacherDTO teacher;

    @ApiModelProperty("学生类")
    private DisciplineDTO discipline;

}
