package com.nhsoft.ledemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 23:36
 * 学科表实体类
 */
@Entity
@Table(name = "discipline")
public class Discipline implements Serializable {

    private static final long serialVersionUID = -3576772963583430665L;

    /**
     * 课程id,主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_dis_id")
    private Long disId;

    /**
     * 课程名字
     */
    @Column(name = "dis_name")
    private String disName;

    /**
     * 课程编号,唯一索引
     */
    @Column(name = "uk_dis_num")
    private String disNum;

    /**
     * 学生学科映射表一对多
     */
    @JsonIgnore
    @OneToMany(mappedBy = "discipline", orphanRemoval = true, fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<StudentDisciplineMapping> students = new HashSet<>();

    /**
     * 老师学科映射表一对多
     */
    @JsonIgnore
    @OneToMany(mappedBy = "discipline", orphanRemoval = true, fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<TeacherDisciplineMapping> teachers = new HashSet<>();


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDisId() {
        return disId;
    }

    public void setDisId(Long disId) {
        this.disId = disId;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public String getDisNum() {
        return disNum;
    }

    public void setDisNum(String disNum) {
        this.disNum = disNum;
    }

    public Set<StudentDisciplineMapping> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentDisciplineMapping> students) {
        this.students = students;
    }

    public Set<TeacherDisciplineMapping> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherDisciplineMapping> teachers) {
        this.teachers = teachers;
    }
}
