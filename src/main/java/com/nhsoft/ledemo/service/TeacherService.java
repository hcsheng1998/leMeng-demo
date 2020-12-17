package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.TeacherDTO;
import com.nhsoft.ledemo.model.Teacher;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/16 : 19:04
 */
public interface TeacherService {

    List<TeacherDTO> batchSaveOrUpdate(List<TeacherDTO> teachers);

    List<Long> batchDelete(List<Long> teaIds);

    Teacher readById(Long teaId);

    List<Teacher> listAll(TeacherDTO teacher);
}
