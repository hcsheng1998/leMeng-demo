package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.StudentDao;
import com.nhsoft.ledemo.dto.StudentDTO;
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
    public Collection<StudentDTO> batchSave(Collection<StudentDTO> collection) {
        collection.forEach(student -> entityManager.persist(student));
        return collection;
    }

    @Override
    public Collection<StudentDTO> batchUpdate(Collection<StudentDTO> collection) {
        collection.forEach(student -> entityManager.merge(student));
        return collection;
    }

    @Override
    public Collection<Long> batchDelete(Collection<Long> stuIds) {

        String jpql = "delete from Student  where stuId = ?1";
        Query query = entityManager.createQuery(jpql);
        stuIds.forEach(id -> query.setParameter(1, id).executeUpdate());
        return stuIds;
    }

    @Override
    public List<Student> listAll(StudentDTO student) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        query.from(Student.class);
        return entityManager.createQuery(query).setFirstResult(student.getPage()).setMaxResults(student.getSize()).getResultList();
    }

    @Override
    public Student readById(Long stuId) {
        return entityManager.find(Student.class, stuId);
    }
}
