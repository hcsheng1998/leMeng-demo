package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 19:44
 */
@ApiModel("老师表实体类")
public class TeacherDTO implements Serializable {

    private static final long serialVersionUID = 202736847978854016L;

    @ApiModelProperty("老师id,主键")
    private Long teaId;

    @ApiModelProperty("老师姓名")
    private String teaName;

    @ApiModelProperty("老师编号,唯一索引")
    private String teaNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getTeaId() {
        return teaId;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(String teaNum) {
        this.teaNum = teaNum;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "teaId=" + teaId +
                ", teaName='" + teaName + '\'' +
                ", teaNum='" + teaNum + '\'' +
                '}';
    }
}
