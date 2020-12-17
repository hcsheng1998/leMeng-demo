package com.nhsoft.ledemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

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

}
