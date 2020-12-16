package com.nhsoft.ledemo.model.uid;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 * 学生课程映射表联合主键封装表
 */
@Embeddable
@Accessors(chain = true)
@Data
public class StudentDisciplineMpUid implements Serializable {

    /**课程主键id*/
    private Long disIdMp;

    /**学生主键id*/
    private Long stuIdMp;

    /**学生学习课程年份*/
    private String years;

    /**学生学习课程学期*/
    private Short semester;

}
