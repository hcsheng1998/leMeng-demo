package com.nhsoft.ledemo.dto.uid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 */
@ApiModel("学生课程映射表联合主键封装表")
public class StudentDisciplineMpUidDTO implements Serializable {

    private static final long serialVersionUID = -1723507111394264256L;

    @ApiModelProperty("课程主键id")
    private Long disIdMp;

    @ApiModelProperty("学生主键id")
    private Long stuIdMp;

    @ApiModelProperty("学生学习课程年份")
    private String years;

    @ApiModelProperty("学生学习课程学期")
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
        return "StudentDisciplineMpUidDTO{" +
                "disIdMp=" + disIdMp +
                ", stuIdMp=" + stuIdMp +
                ", years='" + years + '\'' +
                ", semester=" + semester +
                '}';
    }
}
