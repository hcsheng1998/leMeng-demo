package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.TeacherDTO;
import com.nhsoft.ledemo.model.Teacher;

import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface TeacherDao {
    
    Collection<TeacherDTO> batchSave(Collection<TeacherDTO> collection);

    Collection<TeacherDTO> batchUpdate(Collection<TeacherDTO> collection);

    Collection<Long> batchDelete(Collection<Long> teaIds);

    List<Teacher> listAll(TeacherDTO teacher);

    Teacher readById(Long teaId);
    
}
