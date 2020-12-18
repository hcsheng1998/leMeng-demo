package com.nhsoft.ledemo.dto;

import com.nhsoft.ledemo.dto.uid.StudentTeacherMpUidDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @author heChangSheng
 * @date 2020/12/9 : 20:16
 */
@ApiModel("学生老师映射表实体类")
public class StudentTeacherMappingDTO implements Serializable {

    private static final long serialVersionUID = 3106506185891692084L;

    @ApiModelProperty("学生,老师联合主键封装类对象")
    private StudentTeacherMpUidDTO studentTeacherMpUid = new StudentTeacherMpUidDTO();

    @ApiModelProperty("学生类")
    private StudentDTO student;

    @ApiModelProperty("老师类")
    private TeacherDTO teacher;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public StudentTeacherMpUidDTO getStudentTeacherMpUid() {
        return studentTeacherMpUid;
    }

    public void setStudentTeacherMpUid(StudentTeacherMpUidDTO studentTeacherMpUid) {
        this.studentTeacherMpUid = studentTeacherMpUid;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "StudentTeacherMappingDTO{" +
                "studentTeacherMpUid=" + studentTeacherMpUid +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }
}
