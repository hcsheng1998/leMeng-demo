package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.StudentTeacherMappingDao;
import com.nhsoft.ledemo.dto.StudentTeacherMappingDTO;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author heChangSheng
 * @date 2020/12/17 : 14:55
 */
@Repository
public class StudentTeacherMappingDaoImpl extends BaseDao implements StudentTeacherMappingDao {

    @Override
    public Collection<StudentTeacherMappingDTO> batchSave(Collection<StudentTeacherMappingDTO> collection) {
        collection.forEach(studentTeacherMapping -> entityManager.persist(studentTeacherMapping));
        return collection;
    }

    @Override
    public Collection<StudentTeacherMappingDTO> batchUpdate(Collection<StudentTeacherMappingDTO> collection) {
        collection.forEach(studentTeacherMapping -> entityManager.merge(studentTeacherMapping));
        return collection;
    }
}
