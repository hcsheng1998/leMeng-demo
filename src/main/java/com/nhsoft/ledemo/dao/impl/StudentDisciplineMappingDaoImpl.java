package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.StudentDisciplineMappingDao;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.model.StudentDisciplineMapping;
import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.List;

/**
 * @author hcsheng1998
 */
@Repository
public class StudentDisciplineMappingDaoImpl extends BaseDao implements StudentDisciplineMappingDao {

    @Override
    public List<DisciplineGradeDTO> listDisciplineGrade(StudentDisciplineMpUid studentDisciplineMpUid) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DisciplineGradeDTO> criteriaQuery = criteriaBuilder.createQuery(DisciplineGradeDTO.class);

        Root<StudentDisciplineMapping> root = criteriaQuery.from(StudentDisciplineMapping.class);
        Join<StudentDisciplineMapping, Discipline> join = root.join("discipline", JoinType.LEFT);

        criteriaQuery.multiselect(
                root.get("grade"),
                join.get("disName")
        );

        Path<StudentDisciplineMpUid> path = root.get("studentDisciplineMpUid");
        Predicate stuIdMpPredicate = criteriaBuilder.equal(path.get("stuIdMp"), studentDisciplineMpUid.getStuIdMp());
        Predicate yearsMpPredicate = criteriaBuilder.equal(path.get("years"), studentDisciplineMpUid.getYears());
        criteriaQuery.where(criteriaBuilder.and(stuIdMpPredicate, yearsMpPredicate));
        TypedQuery<DisciplineGradeDTO> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public DisciplineGradeDTO readDisciplineGrade(StudentDisciplineMpUid studentDisciplineMpUid) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DisciplineGradeDTO> criteriaQuery = criteriaBuilder.createQuery(DisciplineGradeDTO.class);

        Root<StudentDisciplineMapping> root = criteriaQuery.from(StudentDisciplineMapping.class);
        Join<StudentDisciplineMapping, Discipline> join = root.join("discipline");

        criteriaQuery.multiselect(
                join.get("disName"),
                criteriaBuilder.avg(root.get("grade")),
                criteriaBuilder.max(root.get("grade")),
                criteriaBuilder.min(root.get("grade"))
        );

        Path<StudentDisciplineMpUid> path = root.get("studentDisciplineMpUid");
        Predicate disIdMpPredicate = criteriaBuilder.equal(path.get("disIdMp"), studentDisciplineMpUid.getDisIdMp());
        Predicate yearsMpPredicate = criteriaBuilder.equal(path.get("years"), studentDisciplineMpUid.getYears());

        criteriaQuery.where(disIdMpPredicate, yearsMpPredicate);

        TypedQuery<DisciplineGradeDTO> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }

    @Override
    public Collection<StudentDisciplineMapping> batchSave(Collection<StudentDisciplineMapping> studentDisciplineMappingCollection) {
        studentDisciplineMappingCollection.forEach(studentDisciplineMapping -> entityManager.persist(studentDisciplineMapping));
        return studentDisciplineMappingCollection;
    }

    @Override
    public Collection<StudentDisciplineMapping> batchUpdate(Collection<StudentDisciplineMapping> studentDisciplineMappingCollection) {
        studentDisciplineMappingCollection.forEach(studentDisciplineMapping -> entityManager.merge(studentDisciplineMapping));
        return studentDisciplineMappingCollection;
    }


}
