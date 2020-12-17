package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.StudentTeacherMappingDTO;

import java.util.Collection;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface StudentTeacherMappingDao {

    Collection<StudentTeacherMappingDTO> batchSave(Collection<StudentTeacherMappingDTO> collection);

    Collection<StudentTeacherMappingDTO> batchUpdate(Collection<StudentTeacherMappingDTO> collection);

}
