package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.TeacherDao;
import com.nhsoft.ledemo.dto.PagingDTO;
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
    public Collection<Teacher> batchSave(Collection<Teacher> teacherCollection) {
        teacherCollection.forEach(teacher -> entityManager.persist(teacher));
        return teacherCollection;
    }

    @Override
    public Collection<Teacher> batchUpdate(Collection<Teacher> teacherCollection) {
        teacherCollection.forEach(teacher -> entityManager.merge(teacher));
        return teacherCollection;
    }

    @Override
    public Collection<Long> batchDelete(Collection<Long> teaIdCollection) {

        String jpql = "delete from Teacher  where teaId = ?1";
        Query query = entityManager.createQuery(jpql);
        teaIdCollection.forEach(id -> query.setParameter(1, id).executeUpdate());
        return teaIdCollection;
    }

    @Override
    public List<Teacher> listAll(PagingDTO pagingDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = criteriaBuilder.createQuery(Teacher.class);
        query.from(Teacher.class);
        return entityManager.createQuery(query).setFirstResult(pagingDTO.getPage()).setMaxResults(pagingDTO.getSize()).getResultList();
    }

    @Override
    public Teacher readById(Long teaId) {
        return entityManager.find(Teacher.class, teaId);
    }
}
