package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Discipline;

import java.util.List;

/**
 * @author hcsheng1998
 */
public interface DisciplineService {

    List<Discipline> batchSaveOrUpdate(List<Discipline> disciplineList);

    List<Long> batchDelete(List<Long> disIdList);

    Discipline read(Long disId);

    /**
     * 查询所有学科并分页
     * @param pagingDTO 自定义分页对象
     * @return
     */
    List<Discipline> listAll(PagingDTO pagingDTO);
}
