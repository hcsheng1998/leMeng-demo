package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.StudentDisciplineMappingDao;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.StudentDisciplineMapping;
import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/15 : 15:35
 */
@Repository
public class StudentDisciplineMappingDaoImpl extends BaseDao implements StudentDisciplineMappingDao {

    @Override
    public List<DisciplineGradeDTO> listDisciplineGrade(StudentDisciplineMpUid studentDisciplineMpUid) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DisciplineGradeDTO> query = criteriaBuilder.createQuery(DisciplineGradeDTO.class);

        Root<StudentDisciplineMapping> sdmFrom = query.from(StudentDisciplineMapping.class);
        Join<Object, Object> dJoin = sdmFrom.join("discipline", JoinType.LEFT);

        query.multiselect(
                sdmFrom.get("grade"),
                dJoin.get("disName")
        );

        Predicate stuIdMp = criteriaBuilder.equal(sdmFrom.get("studentDisciplineMpUid").get("stuIdMp"), studentDisciplineMpUid.getStuIdMp());
        Predicate yearsMp = criteriaBuilder.equal(sdmFrom.get("studentDisciplineMpUid").get("years"), studentDisciplineMpUid.getYears());

        query.where(criteriaBuilder.and(stuIdMp, yearsMp));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public DisciplineGradeDTO readDisciplineGrade(StudentDisciplineMpUid studentDisciplineMpUid) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DisciplineGradeDTO> query = criteriaBuilder.createQuery(DisciplineGradeDTO.class);

        Root<StudentDisciplineMapping> sdmFrom = query.from(StudentDisciplineMapping.class);
        Join<Object, Object> dJoin = sdmFrom.join("discipline");

        query.multiselect(
                dJoin.get("disName"),
                criteriaBuilder.avg(sdmFrom.get("grade")),
                criteriaBuilder.max(sdmFrom.get("grade")),
                criteriaBuilder.min(sdmFrom.get("grade"))
        );

        Predicate disIdMp = criteriaBuilder.equal(sdmFrom.get("studentDisciplineMpUid").get("disIdMp"), studentDisciplineMpUid.getDisIdMp());
        Predicate yearsMp = criteriaBuilder.equal(sdmFrom.get("studentDisciplineMpUid").get("years"), studentDisciplineMpUid.getYears());

        query.where(disIdMp, yearsMp);

        return entityManager.createQuery(query).getSingleResult();
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
