package com.nhsoft.ledemo.dto;

import com.nhsoft.ledemo.dto.uid.StudentTeacherMpUidDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author hcsheng1998
 */
@ApiModel("学生老师映射表实体类")
@Data
public class StudentTeacherMappingDTO implements Serializable {

    private static final long serialVersionUID = 3106506185891692084L;

    @ApiModelProperty("学生,老师联合主键封装类对象")
    private StudentTeacherMpUidDTO studentTeacherMpUid = new StudentTeacherMpUidDTO();

    @ApiModelProperty("学生类")
    private StudentDTO student;

    @ApiModelProperty("老师类")
    private TeacherDTO teacher;

}
