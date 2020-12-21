package com.nhsoft.ledemo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 老师表实体类
 * @author hcsheng1998
 */
@Entity
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
    private String teaName;

    /**
     * 老师编号,唯一索引
     */
    private String teaNum;

    /**
     * 老师课程映射表一对多
     */
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<TeacherDisciplineMapping> students = new HashSet();

    /**
     * 学生老师映射表一对多
     */
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<StudentTeacherMapping> disciplines = new HashSet<>();

}
