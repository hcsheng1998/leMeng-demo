package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 23:36
 */
@ApiModel("课程表实体类")
public class DisciplineDTO implements Serializable {

    private static final long serialVersionUID = -6219660226965727690L;

    @ApiModelProperty("课程id,主键")
    private Long disId;

    @ApiModelProperty("课程名字")
    private String disName;

    @ApiModelProperty("课程编号,唯一索引")
    private String disNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDisId() {
        return disId;
    }

    public void setDisId(Long disId) {
        this.disId = disId;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public String getDisNum() {
        return disNum;
    }

    public void setDisNum(String disNum) {
        this.disNum = disNum;
    }

    @Override
    public String toString() {
        return "DisciplineDTO{" +
                "disId=" + disId +
                ", disName='" + disName + '\'' +
                ", disNum='" + disNum + '\'' +
                '}';
    }
}
