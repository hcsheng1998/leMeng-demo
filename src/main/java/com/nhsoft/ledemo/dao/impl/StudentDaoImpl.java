package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.StudentDao;
import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Student;
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
public class StudentDaoImpl extends BaseDao implements StudentDao {

    @Override
    public Collection<Student> batchSave(Collection<Student> studentCollection) {
        studentCollection.forEach(student -> entityManager.persist(student));
        return studentCollection;
    }

    @Override
    public Collection<Student> batchUpdate(Collection<Student> studentCollection) {
        studentCollection.forEach(student -> entityManager.merge(student));
        return studentCollection;
    }

    @Override
    public Collection<Long> batchDelete(Collection<Long> stuIdCollection) {

        String jpql = "delete from Student  where stuId = :stuId";
        Query query = entityManager.createQuery(jpql);
        stuIdCollection.forEach(id -> {
            query.setParameter("stuId", id);
            query.executeUpdate();
        });
        return stuIdCollection;
    }

    @Override
    public List<Student> listAll(PagingDTO pagingDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        criteriaQuery.from(Student.class);

        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(pagingDTO.getOffset());
        typedQuery.setMaxResults(pagingDTO.getRows());
        return typedQuery.getResultList();

    }

    @Override
    public Student read(Long stuId) {
        return entityManager.find(Student.class, stuId);
    }
}
