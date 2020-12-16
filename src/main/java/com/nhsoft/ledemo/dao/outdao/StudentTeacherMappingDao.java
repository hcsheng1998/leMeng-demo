package com.nhsoft.ledemo.dao.outdao;

import com.nhsoft.ledemo.model.StudentTeacherMapping;
import com.nhsoft.ledemo.model.upk.StudentTeacherMpUid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface StudentTeacherMappingDao extends
        JpaRepository<StudentTeacherMapping, StudentTeacherMpUid>,
        JpaSpecificationExecutor<StudentTeacherMapping> {
}
