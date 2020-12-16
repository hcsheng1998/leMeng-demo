package com.nhsoft.ledemo.dto;

import com.nhsoft.ledemo.dto.Uid.StudentTeacherMpUidDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author heChangSheng
 * @date 2020/12/9 : 20:16
 */
@ApiModel("学生老师映射表实体类")
@Data
public class StudentTeacherMappingDTO {

    @ApiModelProperty("学生,老师联合主键封装类对象")
    private StudentTeacherMpUidDTO studentTeacherMpUid = new StudentTeacherMpUidDTO();

    @ApiModelProperty("学生类")
    private StudentDTO student;

    @ApiModelProperty("老师类")
    private TeacherDTO teacher;

}
