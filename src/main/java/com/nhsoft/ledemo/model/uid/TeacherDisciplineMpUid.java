package com.nhsoft.ledemo.model.uid;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 * 老师课程映射表联合主键封装表
 */
@Embeddable
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDisIdMp() {
        return disIdMp;
    }

    public void setDisIdMp(Long disIdMp) {
        this.disIdMp = disIdMp;
    }

    public Long getTeaIdMp() {
        return teaIdMp;
    }

    public void setTeaIdMp(Long teaIdMp) {
        this.teaIdMp = teaIdMp;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public Short getSemester() {
        return semester;
    }

    public void setSemester(Short semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "TeacherDisciplineMpUid{" +
                "disIdMp=" + disIdMp +
                ", teaIdMp=" + teaIdMp +
                ", years='" + years + '\'' +
                ", semester=" + semester +
                '}';
    }
}
