package com.nhsoft.ledemo.dto.uid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 */
@ApiModel("老师课程映射表联合主键封装表")
public class TeacherDisciplineMpUidDTO implements Serializable {

    private static final long serialVersionUID = 6416271694953797636L;

    @ApiModelProperty("课程主键id")
    private Long disIdMp;

    @ApiModelProperty("老师主键id")
    private Long teaIdMp;

    @ApiModelProperty("某老师讲授某课程的年份")
    private String years;

    @ApiModelProperty("某老师讲授某课程的学期")
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
        return "TeacherDisciplineMpUidDTO{" +
                "disIdMp=" + disIdMp +
                ", teaIdMp=" + teaIdMp +
                ", years='" + years + '\'' +
                ", semester=" + semester +
                '}';
    }
}
