package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.model.Discipline;

import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface DisciplineDao {

    Collection<DisciplineDTO> batchSave(Collection<DisciplineDTO> collection);

    Collection<DisciplineDTO> batchUpdate(Collection<DisciplineDTO> collection);

    Collection<Long> batchDelete(Collection<Long> disIds);

    List<Discipline> listAll(DisciplineDTO discipline);

    Discipline readById(Long disId);
}
