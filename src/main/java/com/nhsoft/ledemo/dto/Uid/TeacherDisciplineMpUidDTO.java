package com.nhsoft.ledemo.dto.Uid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 21:30
 */
@ApiModel("老师课程映射表联合主键封装表")
@Data
public class TeacherDisciplineMpUidDTO implements Serializable {

    @ApiModelProperty("课程主键id")
    private Long disIdMp;

    @ApiModelProperty("老师主键id")
    private Long teaIdMp;

    @ApiModelProperty("某老师讲授某课程的年份")
    private String years;

    @ApiModelProperty("某老师讲授某课程的学期")
    private Short semester;

}
