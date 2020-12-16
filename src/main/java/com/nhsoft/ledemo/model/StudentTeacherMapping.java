package com.nhsoft.ledemo.model;

import com.nhsoft.ledemo.model.uid.StudentTeacherMpUid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


/**
 * @author heChangSheng
 * @date 2020/12/9 : 20:16
 * 学生老师映射表实体类
 */
@Entity
@Table(name = "student_teacher_mapping")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class StudentTeacherMapping {

    /**
     * 学生,老师联合主键封装类对象
     */
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "teaIdMp", column = @Column(name = "pk_tea_id_mp")),
            @AttributeOverride(name = "stuIdMp", column = @Column(name = "pk_stu_id_mp")),
            @AttributeOverride(name = "years", column = @Column(name = "pk_years")),
            @AttributeOverride(name = "semester", column = @Column(name = "pk_semester"))
    })
    private StudentTeacherMpUid studentTeacherMpUid = new StudentTeacherMpUid();

    /**学生表多对一*/
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pk_stu_id_mp", referencedColumnName = "pk_stu_id", insertable=false, updatable=false)
    private Student student;

    /**老师表多对一*/
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pk_tea_id_mp", referencedColumnName = "pk_tea_id", insertable=false, updatable=false)
    private Teacher teacher;

    @Override
    public String toString() {
        return "StudentTeacherMappingPo{" +
                "studentTeacherMpUpk=" + studentTeacherMpUid +
                '}';
    }
}
