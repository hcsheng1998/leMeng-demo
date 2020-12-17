package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/17 : 22:41
 */
public interface TeacherDisciplineMappingService {

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     * @param td
     * @return
     */
    List<TeacherGradeDTO> listTeacherGradeDTO(TeacherDisciplineMpUidDTO td);
}
