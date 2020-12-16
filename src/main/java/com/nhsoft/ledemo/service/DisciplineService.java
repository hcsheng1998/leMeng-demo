package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Discipline;
import org.springframework.data.domain.Page;

/**
 * @author heChangSheng
 * @date 2020/12/16 : 19:03
 */
public interface DisciplineService {

    /**
     * 插入或修改一门学科
     *
     * @param discipline
     * @return
     */
    boolean saveOrUpdate(Discipline discipline);

    /**
     * 删除一门学科
     *
     * @param discipline
     * @return
     */
     boolean delete(DisciplineDTO discipline);

    /**
     * 查询一个学科
     *
     * @param discipline
     * @return
     */
    Discipline read(DisciplineDTO discipline);

    /**
     * 查询所有的学科,并分页
     *
     * @param discipline
     * @return
     */
    Page list(DisciplineDTO discipline);

    /**
     * 查询每学年学科平均成绩，最高分，最低分
     *
     * @param sd
     * @return
     */
    TeacherGradeDTO readTeacherGradeDTO(StudentDisciplineMpUidDTO sd);
}
