package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.StudentDisciplineMapping;
import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;

import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface StudentDisciplineMappingDao {

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

    Collection<StudentDisciplineMapping> batchSave(Collection<StudentDisciplineMapping> studentDisciplineMappingCollection);

    Collection<StudentDisciplineMapping> batchUpdate(Collection<StudentDisciplineMapping> studentDisciplineMappingCollection);

}
