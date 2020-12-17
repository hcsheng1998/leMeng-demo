package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/17 : 22:40
 */
public interface StudentDisciplineMappingService {

    /**
     * 根据学生id查询学生本人每学年各学科成绩
     * @param sd
     * @return
     */
    List<DisciplineGradeDTO> listDisciplineGradeDTO(StudentDisciplineMpUidDTO sd);

    /**
     * 查询每学年学科平均成绩
     * @return
     */
    TeacherGradeDTO readTeacherGradeDTO(StudentDisciplineMpUidDTO sd);
}
