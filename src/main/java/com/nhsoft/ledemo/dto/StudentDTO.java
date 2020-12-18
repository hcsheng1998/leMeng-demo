package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:16
 */
@ApiModel("学生表实体类")
public class StudentDTO implements Serializable {

    private static final long serialVersionUID = -892961838308900105L;

    @ApiModelProperty("学生id,主键")
    private Long stuId;

    @ApiModelProperty("学生姓名")
    private String stuName;

    @ApiModelProperty("学生学号,唯一索引")
    private String stuNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                '}';
    }
}
