package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.uid.TeacherDisciplineMpUid;

import java.util.List;

/**
 * @author hcsheng1998
 */
public interface TeacherDisciplineMappingService {

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     * @param teacherDisciplineMpUid
     * @return 自定义学科成绩类
     */
    List<DisciplineGradeDTO> listDisciplineGrade(TeacherDisciplineMpUid teacherDisciplineMpUid);
}
