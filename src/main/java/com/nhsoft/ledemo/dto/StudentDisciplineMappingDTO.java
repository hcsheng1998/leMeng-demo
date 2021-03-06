package com.nhsoft.ledemo.dto;

import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author hcsheng1998
 */
@ApiModel("学生_课程映射表实体类")
@Data
public class StudentDisciplineMappingDTO implements Serializable {

    private static final long serialVersionUID = -3974051387561909658L;

    @ApiModelProperty("学生,课程联合主键封装类对象")
    private StudentDisciplineMpUidDTO studentDisciplineMpUid = new StudentDisciplineMpUidDTO();

    @ApiModelProperty("学生类")
    private StudentDTO student;

    @ApiModelProperty("学科类")
    private DisciplineDTO discipline;

    @ApiModelProperty("某学生某课程成绩")
    private BigDecimal grade;

}
