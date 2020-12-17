package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.StudentDTO;
import com.nhsoft.ledemo.model.Student;

import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface StudentDao {

    Collection<StudentDTO> batchSave(Collection<StudentDTO> collection);

    Collection<StudentDTO> batchUpdate(Collection<StudentDTO> collection);

    Collection<Long> batchDelete(Collection<Long> stuIds);

    List<Student> listAll(StudentDTO student);

    Student readById(Long stuId);
}
