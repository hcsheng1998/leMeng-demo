package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 17:34
 */
@ApiModel("成绩查询封装类")
public class DisciplineGradeDTO implements Serializable {

    private static final long serialVersionUID = -1323799863811452819L;

    @ApiModelProperty("成绩")
    private BigDecimal grade;

    @ApiModelProperty("学科名称")
    private String disName;

    @ApiModelProperty(value = "平均成绩",example = "1.0")
    private Double avg;

    @ApiModelProperty("最高成绩")
    private BigDecimal max;

    @ApiModelProperty("最低成绩")
    private BigDecimal min;

    public DisciplineGradeDTO() {
    }

    public DisciplineGradeDTO(BigDecimal grade, String disName) {
        this.grade = grade;
        this.disName = disName;
    }

    public DisciplineGradeDTO(String disName, Double avg, BigDecimal max, BigDecimal min) {
        this.disName = disName;
        this.avg = avg;
        this.max = max;
        this.min = min;
    }

    public DisciplineGradeDTO(Double avg, BigDecimal max, BigDecimal min) {
        this.avg = avg;
        this.max = max;
        this.min = min;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "DisciplineGradeDTO{" +
                "grade=" + grade +
                ", disName='" + disName + '\'' +
                ", avg=" + avg +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
