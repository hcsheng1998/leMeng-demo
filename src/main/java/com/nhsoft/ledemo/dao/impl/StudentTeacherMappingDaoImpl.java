package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.StudentTeacherMappingDao;
import com.nhsoft.ledemo.model.StudentTeacherMapping;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author hcsheng1998
 */
@Repository
public class StudentTeacherMappingDaoImpl extends BaseDao implements StudentTeacherMappingDao {

    @Override
    public Collection<StudentTeacherMapping> batchSave(Collection<StudentTeacherMapping> studentTeacherMappingCollection) {
        studentTeacherMappingCollection.forEach(studentTeacherMapping -> entityManager.persist(studentTeacherMapping));
        return studentTeacherMappingCollection;
    }

    @Override
    public Collection<StudentTeacherMapping> batchUpdate(Collection<StudentTeacherMapping> studentTeacherMappingCollection) {
        studentTeacherMappingCollection.forEach(studentTeacherMapping -> entityManager.merge(studentTeacherMapping));
        return studentTeacherMappingCollection;
    }
}
