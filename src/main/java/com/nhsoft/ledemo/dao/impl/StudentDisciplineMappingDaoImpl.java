package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.StudentDisciplineMappingDao;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.StudentDisciplineMappingDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.StudentDisciplineMapping;
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
    public List<DisciplineGradeDTO> listDisciplineGradeDTO(StudentDisciplineMpUidDTO sd) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DisciplineGradeDTO> query = cb.createQuery(DisciplineGradeDTO.class);

        Root<StudentDisciplineMapping> sdmFrom = query.from(StudentDisciplineMapping.class);
        Join<Object, Object> dJoin = sdmFrom.join("discipline", JoinType.LEFT);

        query.multiselect(
                sdmFrom.get("grade"),
                dJoin.get("disName")
        );

        Predicate stuIdMp = cb.equal(sdmFrom.get("studentDisciplineMpUid").get("stuIdMp"), sd.getStuIdMp());
        Predicate yearsMp = cb.equal(sdmFrom.get("studentDisciplineMpUid").get("years"), sd.getYears());

        query.where(cb.and(stuIdMp, yearsMp));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public TeacherGradeDTO readTeacherGradeDTO(StudentDisciplineMpUidDTO sd) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TeacherGradeDTO> query = cb.createQuery(TeacherGradeDTO.class);

        Root<StudentDisciplineMapping> sdmFrom = query.from(StudentDisciplineMapping.class);
        Join<Object, Object> dJoin = sdmFrom.join("discipline");

        query.multiselect(
                dJoin.get("disName"),
                cb.avg(sdmFrom.get("grade")),
                cb.max(sdmFrom.get("grade")),
                cb.min(sdmFrom.get("grade"))
        );

        Predicate disIdMp = cb.equal(sdmFrom.get("studentDisciplineMpUid").get("disIdMp"), sd.getDisIdMp());
        Predicate yearsMp = cb.equal(sdmFrom.get("studentDisciplineMpUid").get("years"), sd.getYears());

        query.where(disIdMp, yearsMp);

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public Collection<StudentDisciplineMappingDTO> batchSave(Collection<StudentDisciplineMappingDTO> collection) {
        collection.forEach(studentDisciplineMapping -> entityManager.persist(studentDisciplineMapping));
        return collection;
    }

    @Override
    public Collection<StudentDisciplineMappingDTO> batchUpdate(Collection<StudentDisciplineMappingDTO> collection) {
        collection.forEach(studentDisciplineMapping -> entityManager.merge(studentDisciplineMapping));
        return collection;
    }


}
