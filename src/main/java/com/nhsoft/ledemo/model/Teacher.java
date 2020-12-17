package com.nhsoft.ledemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 19:44
 * 老师表实体类
 */
@Entity
@Table(name = "teacher")
@Data
public class Teacher implements Serializable {

    private static final long serialVersionUID = -1644368688235923990L;

    /**
     * 老师id,主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_tea_id")
    private Long teaId;

    /**
     * 老师姓名
     */
    @Column(name = "tea_name")
    private String teaName;

    /**
     * 老师编号,唯一索引
     */
    @Column(name = "tea_num")
    private String teaNum;

    /**
     * 老师课程映射表一对多
     */
    @JsonIgnore
    @OneToMany(mappedBy = "teacher", orphanRemoval = true, fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<TeacherDisciplineMapping> students = new HashSet();

    /**
     * 学生老师映射表一对多
     */
    @JsonIgnore
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, orphanRemoval = true,cascade = CascadeType.PERSIST)
    private Set<StudentTeacherMapping> disciplines = new HashSet<>();

}
