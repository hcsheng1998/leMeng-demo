package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.TeacherDisciplineMappingDao;
import com.nhsoft.ledemo.dto.TeacherDisciplineMappingDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.TeacherDisciplineMapping;
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
    public List<TeacherGradeDTO> listTeacherGradeDTO(TeacherDisciplineMpUidDTO td) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TeacherGradeDTO> query = cb.createQuery(TeacherGradeDTO.class);

        Root<TeacherDisciplineMapping> tdmFrom = query.from(TeacherDisciplineMapping.class);
        Join<Object, Object> dJoin = tdmFrom.join("discipline", JoinType.LEFT);
        Join<Object, Object> sdmJoin = dJoin.join("students", JoinType.LEFT);

        query.multiselect(
                dJoin.get("disName"),
                cb.avg(sdmJoin.get("grade")),
                cb.max(sdmJoin.get("grade")),
                cb.min(sdmJoin.get("grade"))
        );

        Predicate teaIdMp = cb.equal(tdmFrom.get("teacherDisciplineMpUid").get("teaIdMp"), td.getTeaIdMp());
        Predicate yearsMp = cb.equal(sdmJoin.get("studentDisciplineMpUid").get("years"), td.getYears());
        query.where(cb.and(teaIdMp, yearsMp));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Collection<TeacherDisciplineMappingDTO> batchSave(Collection<TeacherDisciplineMappingDTO> collection) {
        collection.forEach(teacherDisciplineMapping -> entityManager.persist(teacherDisciplineMapping));
        return collection;
    }

    @Override
    public Collection<TeacherDisciplineMappingDTO> batchUpdate(Collection<TeacherDisciplineMappingDTO> collection) {
        collection.forEach(teacherDisciplineMapping -> entityManager.merge(teacherDisciplineMapping));
        return collection;
    }
}
