package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.model.Discipline;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/16 : 19:03
 */
public interface DisciplineService {

    List<DisciplineDTO> batchSaveOrUpdate(List<DisciplineDTO> disciplines);

    List<Long> batchDelete(List<Long> disIds);

    Discipline readById(Long disId);

    List<Discipline> listAll(DisciplineDTO discipline);
}
