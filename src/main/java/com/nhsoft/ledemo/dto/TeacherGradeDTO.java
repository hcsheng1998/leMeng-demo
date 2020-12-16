package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 17:34
 */
@ApiModel("成绩和学科查询封装类")
@ToString
@Data
@NoArgsConstructor
public class TeacherGradeDTO implements Serializable {


    @ApiModelProperty("学科名称")
    private String disName;

    @ApiModelProperty(value = "平均成绩",example = "1.0")
    private Double avg;

    @ApiModelProperty("最高成绩")
    private BigDecimal max;

    @ApiModelProperty("最低成绩")
    private BigDecimal min;


    public TeacherGradeDTO(String disName, Double avg, BigDecimal max, BigDecimal min) {
        this.disName = disName;
        this.avg = avg;
        this.max = max;
        this.min = min;
    }

    public TeacherGradeDTO(Double avg, BigDecimal max, BigDecimal min) {
        this.avg = avg;
        this.max = max;
        this.min = min;
    }
}
