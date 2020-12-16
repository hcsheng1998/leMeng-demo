package com.nhsoft.ledemo.dao.basedao;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/15 : 15:33
 */
public interface BaseStudentDisciplineDao {

    /**
     * 根据学生id查询学生本人每学年各学科成绩
     *
     * @param stuId
     * @param years
     * @return
     */
     List<DisciplineGradeDTO> listDisciplineGradeDTO(Long stuId, String years);


    /**
     * 查询每学年学科平均成绩
     * @param disId
     * @param years
     * @return
     */
     TeacherGradeDTO readTeacherGradeDTO(Long disId, String years);
}
