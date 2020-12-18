package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.TeacherDisciplineMappingDao;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.TeacherDisciplineMapping;
import com.nhsoft.ledemo.model.uid.TeacherDisciplineMpUid;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/15 : 15:57
 */
@Repository
public class TeacherDisciplineMappingDaoImpl extends BaseDao implements TeacherDisciplineMappingDao {

    @Override
    public List<DisciplineGradeDTO> listDisciplineGrade(TeacherDisciplineMpUid teacherDisciplineMpUid) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DisciplineGradeDTO> query = criteriaBuilder.createQuery(DisciplineGradeDTO.class);

        Root<TeacherDisciplineMapping> tdmFrom = query.from(TeacherDisciplineMapping.class);
        Join<Object, Object> dJoin = tdmFrom.join("discipline", JoinType.LEFT);
        Join<Object, Object> sdmJoin = dJoin.join("students", JoinType.LEFT);

        query.multiselect(
                dJoin.get("disName"),
                criteriaBuilder.avg(sdmJoin.get("grade")),
                criteriaBuilder.max(sdmJoin.get("grade")),
                criteriaBuilder.min(sdmJoin.get("grade"))
        );

        Predicate teaIdMp = criteriaBuilder.equal(tdmFrom.get("teacherDisciplineMpUid").get("teaIdMp"), teacherDisciplineMpUid.getTeaIdMp());
        Predicate yearsMp = criteriaBuilder.equal(sdmJoin.get("studentDisciplineMpUid").get("years"), teacherDisciplineMpUid.getYears());
        query.where(criteriaBuilder.and(teaIdMp, yearsMp));

        return entityManager.createQuery(query).getResultList();
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
