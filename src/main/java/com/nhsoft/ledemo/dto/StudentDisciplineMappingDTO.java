package com.nhsoft.ledemo.dto;

import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author heChangSheng
 * @date 2020/12/9 : 20:16
 */
@ApiModel("学生_课程映射表实体类")
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public StudentDisciplineMpUidDTO getStudentDisciplineMpUid() {
        return studentDisciplineMpUid;
    }

    public void setStudentDisciplineMpUid(StudentDisciplineMpUidDTO studentDisciplineMpUid) {
        this.studentDisciplineMpUid = studentDisciplineMpUid;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public DisciplineDTO getDiscipline() {
        return discipline;
    }

    public void setDiscipline(DisciplineDTO discipline) {
        this.discipline = discipline;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentDisciplineMappingDTO{" +
                "studentDisciplineMpUid=" + studentDisciplineMpUid +
                ", student=" + student +
                ", discipline=" + discipline +
                ", grade=" + grade +
                '}';
    }
}
