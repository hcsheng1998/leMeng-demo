package com.nhsoft.ledemo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 学生表实体类
 * @author hcsheng1998
 */
@Entity
@Data
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
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<StudentTeacherMapping> teachers = new HashSet<>();

    /**
     * 课程学生映射表一对多
     */
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<StudentDisciplineMapping> disciplines = new HashSet<>();

}
