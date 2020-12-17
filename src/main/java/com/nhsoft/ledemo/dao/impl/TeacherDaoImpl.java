package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.TeacherDao;
import com.nhsoft.ledemo.dto.TeacherDTO;
import com.nhsoft.ledemo.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/17 : 14:53
 */
@Repository
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

    @Override
    public Collection<TeacherDTO> batchSave(Collection<TeacherDTO> collection) {
        collection.forEach(teacher -> entityManager.persist(teacher));
        return collection;
    }

    @Override
    public Collection<TeacherDTO> batchUpdate(Collection<TeacherDTO> collection) {
        collection.forEach(teacher -> entityManager.merge(teacher));
        return collection;
    }

    @Override
    public Collection<Long> batchDelete(Collection<Long> teaIds) {

        String jpql = "delete from Teacher  where teaId = ?1";
        Query query = entityManager.createQuery(jpql);
        teaIds.forEach(id -> query.setParameter(1, id).executeUpdate());
        return teaIds;
    }

    @Override
    public List<Teacher> listAll(TeacherDTO teacher) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = criteriaBuilder.createQuery(Teacher.class);
        query.from(Teacher.class);
        return entityManager.createQuery(query).setFirstResult(teacher.getPage()).setMaxResults(teacher.getSize()).getResultList();
    }

    @Override
    public Teacher readById(Long teaId) {
        return entityManager.find(Teacher.class, teaId);
    }
}
