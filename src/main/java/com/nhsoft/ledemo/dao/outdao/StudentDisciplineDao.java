package com.nhsoft.ledemo.dao.outdao;

import com.nhsoft.ledemo.dao.basedao.BaseStudentDisciplineDao;
import com.nhsoft.ledemo.model.StudentDisciplineMapping;
import com.nhsoft.ledemo.model.upk.StudentDisciplineMpUid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface StudentDisciplineDao extends
        JpaRepository<StudentDisciplineMapping, StudentDisciplineMpUid>,
        JpaSpecificationExecutor<StudentDisciplineMapping>,
        BaseStudentDisciplineDao {
}
