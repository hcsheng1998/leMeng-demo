package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/17 : 22:40
 */
public interface StudentDisciplineMappingService {

    /**
     * 根据学生id查询学生本人每学年各学科成绩
     * @param studentDisciplineMpUid
     * @return 自定义学科成绩类
     */
    List<DisciplineGradeDTO> listDisciplineGrade(StudentDisciplineMpUid studentDisciplineMpUid);

    /**
     * 查询每学年学科平均成绩
     * @param studentDisciplineMpUid
     * @return 自定义学科成绩类
     */
    DisciplineGradeDTO readDisciplineGrade(StudentDisciplineMpUid studentDisciplineMpUid);
}
