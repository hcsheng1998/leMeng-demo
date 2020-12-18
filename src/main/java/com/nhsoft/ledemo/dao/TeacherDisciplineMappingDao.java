package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.TeacherDisciplineMapping;
import com.nhsoft.ledemo.model.uid.TeacherDisciplineMpUid;

import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface TeacherDisciplineMappingDao {

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     * @param teacherDisciplineMpUid
     * @return 自定义学科成绩类
     */
    List<DisciplineGradeDTO> listDisciplineGrade(TeacherDisciplineMpUid teacherDisciplineMpUid);

    Collection<TeacherDisciplineMapping> batchSave(Collection<TeacherDisciplineMapping> teacherDisciplineMappingCollection);

    Collection<TeacherDisciplineMapping> batchUpdate(Collection<TeacherDisciplineMapping> teacherDisciplineMappingCollection);
}
