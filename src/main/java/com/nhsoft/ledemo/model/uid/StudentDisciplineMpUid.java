package com.nhsoft.ledemo.model.uid;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 * 学生课程映射表联合主键封装表
 */
@Embeddable
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDisIdMp() {
        return disIdMp;
    }

    public void setDisIdMp(Long disIdMp) {
        this.disIdMp = disIdMp;
    }

    public Long getStuIdMp() {
        return stuIdMp;
    }

    public void setStuIdMp(Long stuIdMp) {
        this.stuIdMp = stuIdMp;
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
        return "StudentDisciplineMpUid{" +
                "disIdMp=" + disIdMp +
                ", stuIdMp=" + stuIdMp +
                ", years='" + years + '\'' +
                ", semester=" + semester +
                '}';
    }
}
