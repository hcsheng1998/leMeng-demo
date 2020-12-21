package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hcsheng1998
 */
@ApiModel("成绩查询封装类")
@Data
@NoArgsConstructor
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
}
