package com.nhsoft.ledemo.model;

import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 学生学科映射表实体类
 * @author hcsheng1998
 */
@Entity
@Data
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pk_stu_id_mp", referencedColumnName = "pk_stu_id", insertable = false, updatable = false)
    private Student student;

    /**
     * 老师表多对一
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pk_dis_id_mp", referencedColumnName = "pk_dis_id", insertable = false, updatable = false)
    private Discipline discipline;

    /**
     * 某学生某课程成绩
     */
    private BigDecimal grade;

}
