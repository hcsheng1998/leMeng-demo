package com.nhsoft.ledemo.dao.outdao;

import com.nhsoft.ledemo.dao.basedao.BaseTeacherDisciplineMappingDao;
import com.nhsoft.ledemo.model.TeacherDisciplineMapping;
import com.nhsoft.ledemo.model.uid.TeacherDisciplineMpUid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface TeacherDisciplineMappingDao extends
        JpaRepository<TeacherDisciplineMapping, TeacherDisciplineMpUid>,
        JpaSpecificationExecutor<TeacherDisciplineMapping>,
        BaseTeacherDisciplineMappingDao {

}
