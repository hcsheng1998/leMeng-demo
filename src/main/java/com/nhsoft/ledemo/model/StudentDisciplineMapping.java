package com.nhsoft.ledemo.model;

import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author heChangSheng
 * @date 2020/12/9 : 20:16
 * 学生学科映射表实体类
 */
@Entity
@Table(name = "student_discipline_mapping")
public class StudentDisciplineMapping implements Serializable {

    private static final long serialVersionUID = -4639557825595705571L;

    /**
     * 学生,课程联合主键封装类对象
     */
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "disIdMp", column = @Column(name = "pk_dis_id_mp")),
            @AttributeOverride(name = "stuIdMp", column = @Column(name = "pk_stu_id_mp")),
            @AttributeOverride(name = "years", column = @Column(name = "pk_years")),
            @AttributeOverride(name = "semester", column = @Column(name = "pk_semester")),
    })
    private StudentDisciplineMpUid studentDisciplineMpUid = new StudentDisciplineMpUid();

    /**
     * 学生表多对一
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pk_stu_id_mp", referencedColumnName = "pk_stu_id", insertable = false, updatable = false)
    private Student student;

    /**
     * 老师表多对一
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pk_dis_id_mp", referencedColumnName = "pk_dis_id", insertable = false, updatable = false)
    private Discipline discipline;

    /**
     * 某学生某课程成绩
     */
    @Column(name = "grade")
    private BigDecimal grade;

    public StudentDisciplineMapping() {
    }

    public StudentDisciplineMapping(StudentDisciplineMpUid studentDisciplineMpUid) {
        this.studentDisciplineMpUid = studentDisciplineMpUid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public StudentDisciplineMpUid getStudentDisciplineMpUid() {
        return studentDisciplineMpUid;
    }

    public void setStudentDisciplineMpUid(StudentDisciplineMpUid studentDisciplineMpUid) {
        this.studentDisciplineMpUid = studentDisciplineMpUid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
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
        return "StudentDisciplineMappingPo{" +
                "studentDisciplineMpUpk=" + studentDisciplineMpUid +
                ", grade=" + grade +
                '}';
    }
}
