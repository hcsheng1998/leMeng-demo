package com.nhsoft.ledemo.dao.basedao.impl;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.model.StudentDisciplineMapping;
import com.nhsoft.ledemo.dao.basedao.BaseStudentDisciplineDao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/15 : 15:35
 */
public class BaseStudentDisciplineDaoImpl implements BaseStudentDisciplineDao {

    @Resource
    private EntityManager entityManager;

    /**
     *   @Query(value = "select new com.nhsoft.ledemo.dto.DisciplineGradeDao(sdm.grade,d.disName) from StudentDisciplineMappingPo sdm left join DisciplinePo d on\n" +
     *             "sdm.studentDisciplineMpUpk.disIdMp = d.disId where sdm.studentDisciplineMpUpk.stuIdMp = ?1 and sdm.studentDisciplineMpUpk.years = ?2")
     */
    @Override
    public List<DisciplineGradeDTO> listDisciplineGradeDTO(Long stuId, String years) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DisciplineGradeDTO> query = cb.createQuery(DisciplineGradeDTO.class);

        Root<StudentDisciplineMapping> sdmFrom = query.from(StudentDisciplineMapping.class);
        Join<Object, Object> dJoin = sdmFrom.join("discipline", JoinType.LEFT);

        query.multiselect(
                sdmFrom.get("grade"),
                dJoin.get("disName")
        );

        Predicate stuIdMp = cb.equal(sdmFrom.get("studentDisciplineMpUid").get("stuIdMp"), stuId);
        Predicate yearsMp = cb.equal(sdmFrom.get("studentDisciplineMpUid").get("years"), years);

        query.where(cb.and(stuIdMp, yearsMp));

        return entityManager.createQuery(query).getResultList();
    }

    /**
     *   @Query(value = "select new com.nhsoft.ledemo.dto.TeacherGradeDao(d.disName,avg(sdm.grade) ,max(sdm.grade),min(sdm.grade))\n" +
     *             "from StudentDisciplineMappingPo sdm\n" +
     *             "left join DisciplinePo d on sdm.studentDisciplineMpUpk.disIdMp = d.disId\n" +
     *             "where sdm.studentDisciplineMpUpk.disIdMp = ?1 and sdm.studentDisciplineMpUpk.years = ?2")
     */
    @Override
    public TeacherGradeDTO readTeacherGradeDTO(Long disId, String years) {

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

        Predicate disIdMp = cb.equal(sdmFrom.get("studentDisciplineMpUid").get("disIdMp"), disId);
        Predicate yearsMp = cb.equal(sdmFrom.get("studentDisciplineMpUid").get("years"), years);

        query.where(disIdMp, yearsMp);

        return entityManager.createQuery(query).getSingleResult();
    }
}
