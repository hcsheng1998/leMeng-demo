package com.nhsoft.ledemo.dto;

import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @author heChangSheng
 * @date 2020/12/9 : 20:16
 */
@ApiModel("老师课程映射表实体类")
public class TeacherDisciplineMappingDTO implements Serializable {

    private static final long serialVersionUID = 5967761442169086198L;

    @ApiModelProperty("老师,课程联合主键封装类对象")
    private TeacherDisciplineMpUidDTO teacherDisciplineMpUid = new TeacherDisciplineMpUidDTO();

    @ApiModelProperty("老师类")
    private TeacherDTO teacher;

    @ApiModelProperty("学生类")
    private DisciplineDTO discipline;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public TeacherDisciplineMpUidDTO getTeacherDisciplineMpUid() {
        return teacherDisciplineMpUid;
    }

    public void setTeacherDisciplineMpUid(TeacherDisciplineMpUidDTO teacherDisciplineMpUid) {
        this.teacherDisciplineMpUid = teacherDisciplineMpUid;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public DisciplineDTO getDiscipline() {
        return discipline;
    }

    public void setDiscipline(DisciplineDTO discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "TeacherDisciplineMappingDTO{" +
                "teacherDisciplineMpUid=" + teacherDisciplineMpUid +
                ", teacher=" + teacher +
                ", discipline=" + discipline +
                '}';
    }
}
