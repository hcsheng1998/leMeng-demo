package com.nhsoft.ledemo.dto.uid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hcsheng1998
 */
@ApiModel("学生老师映射表联合主键封装表")
@Data
public class StudentTeacherMpUidDTO implements Serializable {

    private static final long serialVersionUID = -5510541317253408449L;

    @ApiModelProperty("老师主键id")
    private Long teaIdMp;

    @ApiModelProperty("学生主键id")
    private Long stuIdMp;

    @ApiModelProperty("学生跟随老师学习的年份")
    private String years;

    @ApiModelProperty("学生跟随老师学习的学期")
    private Short semester;

}
