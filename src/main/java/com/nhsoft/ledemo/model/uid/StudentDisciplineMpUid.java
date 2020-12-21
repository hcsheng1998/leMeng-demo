package com.nhsoft.ledemo.model.uid;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 学生课程映射表联合主键封装表
 * @author hcsheng1998
 */
@Embeddable
@Data
public class StudentDisciplineMpUid implements Serializable {

    private static final long serialVersionUID = 4170979492868219252L;

    /**
     * 课程主键id
     */
    private Long disIdMp;

    /**
     * 学生主键id
     */
    private Long stuIdMp;

    /**
     * 学生学习课程年份
     */
    private String years;

    /**
     * 学生学习课程学期
     */
    private Short semester;

}
