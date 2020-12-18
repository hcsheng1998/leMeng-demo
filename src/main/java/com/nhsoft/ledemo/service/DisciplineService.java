package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Discipline;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/16 : 19:03
 */
public interface DisciplineService {

    List<Discipline> batchSaveOrUpdate(List<Discipline> disciplineList);

    List<Long> batchDelete(List<Long> disIdList);

    Discipline readById(Long disId);

    /**
     * 查询所有学科并分页
     * @param pagingDTO 自定义分页对象
     * @return
     */
    List<Discipline> listAll(PagingDTO pagingDTO);
}
