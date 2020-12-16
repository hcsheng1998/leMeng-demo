package com.nhsoft.ledemo.model;

import com.nhsoft.ledemo.model.uid.TeacherDisciplineMpUid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


/**
 * @author heChangSheng
 * @date 2020/12/9 : 20:16
 * 老师课程映射表实体类
 */
@Entity
@Table(name = "teacher_discipline_mapping")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class TeacherDisciplineMapping {

    /**老师,课程联合主键封装类对象*/
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "disIdMp",column = @Column(name = "pk_dis_id_mp")),
            @AttributeOverride(name = "teaIdMp",column = @Column(name = "pk_tea_id_mp")),
            @AttributeOverride(name = "years",column = @Column(name = "pk_years")),
            @AttributeOverride(name = "semester",column = @Column(name = "pk_semester"))
    })
    private TeacherDisciplineMpUid teacherDisciplineMpUid = new TeacherDisciplineMpUid();

    /**老师表多对一*/
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pk_tea_id_mp", referencedColumnName = "pk_tea_id", insertable=false, updatable=false)
    private Teacher teacher;

    /**学科表多对一*/
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pk_dis_id_mp", referencedColumnName = "pk_dis_id", insertable=false, updatable=false)
    private Discipline discipline;

    @Override
    public String toString() {
        return "TeacherDisciplineMappingPo{" +
                "teacherDisciplineMpUpk=" + teacherDisciplineMpUid +
                '}';
    }
}
