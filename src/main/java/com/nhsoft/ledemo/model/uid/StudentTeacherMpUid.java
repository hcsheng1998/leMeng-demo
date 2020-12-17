package com.nhsoft.ledemo.model.uid;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 * 学生老师映射表联合主键封装表
 */
@Embeddable
@Accessors(chain = true)
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
