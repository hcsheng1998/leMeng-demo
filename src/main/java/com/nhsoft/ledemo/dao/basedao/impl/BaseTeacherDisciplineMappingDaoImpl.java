package com.nhsoft.ledemo.dao.basedao.impl;

import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.model.TeacherDisciplineMapping;
import com.nhsoft.ledemo.dao.basedao.BaseTeacherDisciplineMappingDao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/15 : 15:57
 */
public class BaseTeacherDisciplineMappingDaoImpl implements BaseTeacherDisciplineMappingDao {

    @Resource
    private EntityManager entityManager;

    /**
     * @Query(value = "select new com.nhsoft.ledemo.dto.TeacherGradeDao(d.disName,avg(sdm.grade) ,max(sdm.grade),min(sdm.grade))\n" +
     * "from TeacherDisciplineMappingPo tdm\n" +
     * "left join DisciplinePo d on tdm.teacherDisciplineMpUpk.disIdMp = d.disId\n" +
     * "left join StudentDisciplineMappingPo sdm on tdm.teacherDisciplineMpUpk.disIdMp = sdm.studentDisciplineMpUpk.disIdMp\n" +
     * "where tdm.teacherDisciplineMpUpk.teaIdMp = ?1 and sdm.studentDisciplineMpUpk.years = ?2 group by tdm.teacherDisciplineMpUpk.disIdMp")
     */
    @Override
    public List<TeacherGradeDTO> listTeacherGradeDTO(Long teaId, String years) {

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

        Predicate teaIdMp = cb.equal(tdmFrom.get("teacherDisciplineMpUid").get("teaIdMp"), teaId);
        Predicate yearsMp = cb.equal(sdmJoin.get("studentDisciplineMpUid").get("years"), years);
        query.where(cb.and(teaIdMp, yearsMp));

        return entityManager.createQuery(query).getResultList();
    }
}
