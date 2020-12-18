package com.nhsoft.ledemo.model.uid;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 * 学生老师映射表联合主键封装表
 */
@Embeddable
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getTeaIdMp() {
        return teaIdMp;
    }

    public void setTeaIdMp(Long teaIdMp) {
        this.teaIdMp = teaIdMp;
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
        return "StudentTeacherMpUid{" +
                "teaIdMp=" + teaIdMp +
                ", stuIdMp=" + stuIdMp +
                ", years='" + years + '\'' +
                ", semester=" + semester +
                '}';
    }
}
