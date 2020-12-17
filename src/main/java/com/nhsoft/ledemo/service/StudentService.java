package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.StudentDTO;
import com.nhsoft.ledemo.model.Student;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/16 : 19:04
 */
public interface StudentService {

    List<StudentDTO> batchSaveOrUpdate(List<StudentDTO> students);

    List<Long> batchDelete(List<Long> stuIds);

    Student readById(Long stuId);

    List<Student> listAll(StudentDTO student);
}
