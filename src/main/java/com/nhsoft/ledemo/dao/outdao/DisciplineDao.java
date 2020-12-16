package com.nhsoft.ledemo.dao.outdao;

import com.nhsoft.ledemo.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface DisciplineDao extends JpaRepository<Discipline,Long>, JpaSpecificationExecutor<Discipline> {
}
