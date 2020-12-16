package com.nhsoft.ledemo.dao.basedao;

import com.nhsoft.ledemo.dto.TeacherGradeDTO;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/15 : 15:56
 */
public interface BaseTeacherDisciplineMappingDao {

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     * @param teaId
     * @param years
     * @return
     */
    public List<TeacherGradeDTO> listTeacherGradeDTO(Long teaId, String years);
}
