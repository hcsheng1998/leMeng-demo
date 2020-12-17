package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 17:34
 */
@ApiModel("成绩和学科查询封装类")
@Data
@NoArgsConstructor
public class DisciplineGradeDTO implements Serializable {

    private static final long serialVersionUID = 2213510509303457998L;

    @ApiModelProperty("成绩")
    private BigDecimal grade;

    @ApiModelProperty("学科名称")
    private String disName;

    public DisciplineGradeDTO(BigDecimal grade, String disName) {
        this.grade = grade;
        this.disName = disName;
    }

    public DisciplineGradeDTO(BigDecimal grade) {
        this.grade = grade;
    }
}
