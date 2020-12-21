package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.model.StudentTeacherMapping;

import java.util.Collection;

/**
 * @author hcsheng1998
 */
public interface StudentTeacherMappingDao {

    Collection<StudentTeacherMapping> batchSave(Collection<StudentTeacherMapping> studentTeacherMappingCollection);

    Collection<StudentTeacherMapping> batchUpdate(Collection<StudentTeacherMapping> studentTeacherMappingCollection);

}
