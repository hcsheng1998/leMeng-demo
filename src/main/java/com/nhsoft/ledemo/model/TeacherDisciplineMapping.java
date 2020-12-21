package com.nhsoft.ledemo.model;

import com.nhsoft.ledemo.model.uid.TeacherDisciplineMpUid;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 老师课程映射表实体类
 * @author hcsheng1998
 */
@Entity
@Data
public class TeacherDisciplineMapping implements Serializable {

    private static final long serialVersionUID = 4237333728479430904L;

    /**
     * 老师,课程联合主键封装类对象
     */
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "disIdMp",column = @Column(name = "pk_dis_id_mp")),
            @AttributeOverride(name = "teaIdMp",column = @Column(name = "pk_tea_id_mp")),
            @AttributeOverride(name = "years",column = @Column(name = "pk_years")),
            @AttributeOverride(name = "semester",column = @Column(name = "pk_semester"))
    })
    private TeacherDisciplineMpUid teacherDisciplineMpUid = new TeacherDisciplineMpUid();

    /**
     * 老师表多对一
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pk_tea_id_mp", referencedColumnName = "pk_tea_id", insertable=false, updatable=false)
    private Teacher teacher;

    /**
     * 学科表多对一
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pk_dis_id_mp", referencedColumnName = "pk_dis_id", insertable=false, updatable=false)
    private Discipline discipline;

}
