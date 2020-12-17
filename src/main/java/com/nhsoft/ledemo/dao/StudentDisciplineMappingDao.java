package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.StudentDisciplineMappingDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;

import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface StudentDisciplineMappingDao {

    /**
     * 根据学生id查询学生本人每学年各学科成绩
     * @param sd
     * @return
     */
    List<DisciplineGradeDTO> listDisciplineGradeDTO(StudentDisciplineMpUidDTO sd);

    /**
     * 查询每学年学科平均成绩
     * @param sd
     * @return
     */
    TeacherGradeDTO readTeacherGradeDTO(StudentDisciplineMpUidDTO sd);

    Collection<StudentDisciplineMappingDTO> batchSave(Collection<StudentDisciplineMappingDTO> collection);

    Collection<StudentDisciplineMappingDTO> batchUpdate(Collection<StudentDisciplineMappingDTO> collection);

}
