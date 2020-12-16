package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.StudentDTO;
import com.nhsoft.ledemo.dto.Uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/16 : 19:04
 */
public interface StudentService {

    /**
     * 插入或修改一个学生
     *
     * @param student
     * @return
     */
    boolean saveOrUpdate(Student student);

    /**
     * 删除一个学生
     *
     * @param student
     * @return
     */
    boolean delete(StudentDTO student);

    /**
     * 查询一个学生
     *
     * @param student
     * @return
     */
    Student read(StudentDTO student);

    /**
     * 查询所有的学生,并分页
     *
     * @param student
     * @return
     */
    Page list(StudentDTO student);

    /**
     * 根据学生id查询学生本人每学年各学科成绩
     *
     * @param sd
     * @return
     */
    List<DisciplineGradeDTO> listDisciplineGradeDTO(StudentDisciplineMpUidDTO sd);
}
