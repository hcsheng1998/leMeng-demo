package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.TeacherDisciplineMappingDao;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.model.StudentDisciplineMapping;
import com.nhsoft.ledemo.model.TeacherDisciplineMapping;
import com.nhsoft.ledemo.model.uid.TeacherDisciplineMpUid;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.List;

/**
 * @author hcsheng1998
 */
@Repository
public class TeacherDisciplineMappingDaoImpl extends BaseDao implements TeacherDisciplineMappingDao {

    @Override
    public List<DisciplineGradeDTO> listDisciplineGrade(TeacherDisciplineMpUid teacherDisciplineMpUid) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DisciplineGradeDTO> criteriaQuery = criteriaBuilder.createQuery(DisciplineGradeDTO.class);

        Root<TeacherDisciplineMapping> root = criteriaQuery.from(TeacherDisciplineMapping.class);
        Join<TeacherDisciplineMapping, Discipline> disciplineJoin = root.join("discipline", JoinType.LEFT);
        Join<Discipline, StudentDisciplineMapping> disciplineStudentDisciplineMappingJoin = disciplineJoin.join("students", JoinType.LEFT);

        criteriaQuery.multiselect(
                disciplineJoin.get("disName"),
                criteriaBuilder.avg(disciplineStudentDisciplineMappingJoin.get("grade")),
                criteriaBuilder.max(disciplineStudentDisciplineMappingJoin.get("grade")),
                criteriaBuilder.min(disciplineStudentDisciplineMappingJoin.get("grade"))
        );
        Path<Object> path = root.get("teacherDisciplineMpUid");
        Predicate teaIdMpPredicate = criteriaBuilder.equal(path.get("teaIdMp"), teacherDisciplineMpUid.getTeaIdMp());
        Predicate yearsMpPredicate = criteriaBuilder.equal(path.get("years"), teacherDisciplineMpUid.getYears());
        criteriaQuery.where(criteriaBuilder.and(teaIdMpPredicate, yearsMpPredicate));

        TypedQuery<DisciplineGradeDTO> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public Collection<TeacherDisciplineMapping> batchSave(Collection<TeacherDisciplineMapping> teacherDisciplineMappingCollection) {
        teacherDisciplineMappingCollection.forEach(teacherDisciplineMapping -> entityManager.persist(teacherDisciplineMapping));
        return teacherDisciplineMappingCollection;
    }

    @Override
    public Collection<TeacherDisciplineMapping> batchUpdate(Collection<TeacherDisciplineMapping> teacherDisciplineMappingCollection) {
        teacherDisciplineMappingCollection.forEach(teacherDisciplineMapping -> entityManager.merge(teacherDisciplineMapping));
        return teacherDisciplineMappingCollection;
    }
}
