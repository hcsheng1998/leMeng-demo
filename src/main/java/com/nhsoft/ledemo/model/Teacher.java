package com.nhsoft.ledemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nhsoft.ledemo.dto.PagingDTO;
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
public class Teacher extends PagingDTO implements Serializable {

    /**老师id,主键*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_tea_id")
    private Long teaId;

    /**老师姓名*/
    @Column(name = "tea_name")
    private String teaName;

    /**老师编号,唯一索引*/
    @Column(name = "tea_num")
    private String teaNum;

    /**保存学生集合,老师_学生多对多设置*/
    @JsonIgnore
    @OneToMany(mappedBy = "teacher", orphanRemoval = true, fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<TeacherDisciplineMapping> students = new HashSet();

    /**保存课程集合,老师_课程多对多设置*/
    @JsonIgnore
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, orphanRemoval = true,cascade = CascadeType.PERSIST)
    private Set<TeacherDisciplineMapping> disciplines = new HashSet<>();

}
