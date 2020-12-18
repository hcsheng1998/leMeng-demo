package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.StudentDao;
import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Student;
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

        String jpql = "delete from Student  where stuId = ?1";
        Query query = entityManager.createQuery(jpql);
        stuIdCollection.forEach(id -> query.setParameter(1, id).executeUpdate());
        return stuIdCollection;
    }

    @Override
    public List<Student> listAll(PagingDTO pagingDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        query.from(Student.class);
        return entityManager.createQuery(query).setFirstResult(pagingDTO.getPage()).setMaxResults(pagingDTO.getSize()).getResultList();
    }

    @Override
    public Student readById(Long stuId) {
        return entityManager.find(Student.class, stuId);
    }
}
