package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.TeacherDao;
import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;
import java.util.List;

/**
 * @author hcsheng1998
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

        String jpql = "delete from Teacher  where teaId = :teaId";
        Query query = entityManager.createQuery(jpql);
        teaIdCollection.forEach(id -> {
            query.setParameter("teaId", id);
            query.executeUpdate();
        });
        return teaIdCollection;
    }

    @Override
    public List<Teacher> listAll(PagingDTO pagingDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteriaQuery = criteriaBuilder.createQuery(Teacher.class);
        criteriaQuery.from(Teacher.class);

        TypedQuery<Teacher> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(pagingDTO.getOffset());
        typedQuery.setMaxResults(pagingDTO.getRows());
        return typedQuery.getResultList();
    }

    @Override
    public Teacher read(Long teaId) {
        return entityManager.find(Teacher.class, teaId);
    }
}
