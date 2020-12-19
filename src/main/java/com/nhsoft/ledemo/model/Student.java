package com.nhsoft.ledemo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:16
 * 学生表实体类
 */
@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 931304113468729139L;

    /**
     * 学生id,主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_stu_id")
    private Long stuId;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 学生学号,唯一索引
     */
    private String stuNum;

    /**
     * 老师学生映射表一对多
     */
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, orphanRemoval = true,cascade = CascadeType.PERSIST)
    private Set<StudentTeacherMapping> teachers = new HashSet<>();

    /**
     * 课程学生映射表一对多
     */
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, orphanRemoval = true,cascade = CascadeType.PERSIST)
    private Set<StudentDisciplineMapping> disciplines = new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public Set<StudentTeacherMapping> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<StudentTeacherMapping> teachers) {
        this.teachers = teachers;
    }

    public Set<StudentDisciplineMapping> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<StudentDisciplineMapping> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", teachers=" + teachers +
                ", disciplines=" + disciplines +
                '}';
    }
}
