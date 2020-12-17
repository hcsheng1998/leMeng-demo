package com.nhsoft.ledemo.model.uid;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 * 老师课程映射表联合主键封装表
 */
@Embeddable
@Accessors(chain = true)
@Data
public class TeacherDisciplineMpUid implements Serializable {

    private static final long serialVersionUID = -5517057517770260385L;

    /**
     * 课程主键id
     */
    private Long disIdMp;

    /**
     * 老师主键id
     */
    private Long teaIdMp;

    /**
     * 某老师讲授某课程的年份
     */
    private String years;

    /**
     * 某老师讲授某课程的学期
     */
    private Short semester;

}
