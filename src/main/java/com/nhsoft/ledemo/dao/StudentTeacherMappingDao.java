package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.model.StudentTeacherMapping;

import java.util.Collection;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface StudentTeacherMappingDao {

    Collection<StudentTeacherMapping> batchSave(Collection<StudentTeacherMapping> studentTeacherMappingCollection);

    Collection<StudentTeacherMapping> batchUpdate(Collection<StudentTeacherMapping> studentTeacherMappingCollection);

}
