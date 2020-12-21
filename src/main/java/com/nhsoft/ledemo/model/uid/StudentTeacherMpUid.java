package com.nhsoft.ledemo.model.uid;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 学生老师映射表联合主键封装表
 * @author hcsheng1998
 */
@Embeddable
@Data
public class StudentTeacherMpUid implements Serializable {

    private static final long serialVersionUID = -8731852262793616836L;

    /**
     * 老师主键id
     */
    private Long teaIdMp;

    /**
     * 学生主键id
     */
    private Long stuIdMp;

    /**
     * 学生跟随老师学习的年份
     */
    private String years;

    /**
     * 学生跟随老师学习的学期
     */
    private Short semester;

}
