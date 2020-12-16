package com.nhsoft.ledemo.dto;

import com.nhsoft.ledemo.dto.Uid.TeacherDisciplineMpUidDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author heChangSheng
 * @date 2020/12/9 : 20:16
 */
@ApiModel("老师课程映射表实体类")
@Data
public class TeacherDisciplineMappingDTO {


    @ApiModelProperty("老师,课程联合主键封装类对象")
    private TeacherDisciplineMpUidDTO teacherDisciplineMpUid = new TeacherDisciplineMpUidDTO();

    @ApiModelProperty("老师类")
    private TeacherDTO teacher;

    @ApiModelProperty("学生类")
    private DisciplineDTO discipline;

}
