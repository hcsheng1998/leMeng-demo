package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.TeacherDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.Uid.TeacherDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Teacher;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/16 : 19:04
 */
public interface TeacherService {

    /**
     * 插入或修改一门老师
     *
     * @param teacher
     * @return
     */
    boolean saveOrUpdate(Teacher teacher);

    /**
     * 删除一门老师
     *
     * @param teacher
     * @return
     */
    boolean delete(TeacherDTO teacher);

    /**
     * 查询一个老师
     *
     * @param teacher
     * @return
     */
    Teacher read(TeacherDTO teacher);

    /**
     * 查询所有的老师,并分页
     *
     * @param teacher
     * @return
     */
    Page list(TeacherDTO teacher);

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param td
     * @return
     */
    List<TeacherGradeDTO> listTeacherGradeDTO(TeacherDisciplineMpUidDTO td);
}
