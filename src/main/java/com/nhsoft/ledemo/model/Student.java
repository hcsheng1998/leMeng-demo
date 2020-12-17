package com.nhsoft.ledemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

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
@Table(name = "student")
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
    @Column(name = "stu_name")
    private String stuName;

    /**
     * 学生学号,唯一索引
     */
    @Column(name = "stu_num")
    private String stuNum;

    /**
     * 老师学生映射表一对多
     */
    @JsonIgnore
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, orphanRemoval = true,cascade = CascadeType.PERSIST)
    private Set<StudentTeacherMapping> teachers = new HashSet<>();

    /**
     * 课程学生映射表一对多
     */
    @JsonIgnore
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, orphanRemoval = true,cascade = CascadeType.PERSIST)
    private Set<StudentDisciplineMapping> disciplines = new HashSet<>();

}
