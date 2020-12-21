package com.nhsoft.ledemo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 学科表实体类
 * @author hcsheng1998
 */
@Entity
@Data
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
    private String disName;

    /**
     * 课程编号,唯一索引
     */
    private String disNum;

    /**
     * 学生学科映射表一对多
     */
    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    private Set<StudentDisciplineMapping> students = new HashSet<>();

    /**
     * 老师学科映射表一对多
     */
    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    private Set<TeacherDisciplineMapping> teachers = new HashSet<>();

}
