package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Discipline;

import java.util.Collection;
import java.util.List;

/**
 * @author hcsheng1998
 */
public interface DisciplineDao {

    Collection<Discipline> batchSave(Collection<Discipline> disciplineCollection);

    Collection<Discipline> batchUpdate(Collection<Discipline> disciplineCollection);

    Collection<Long> batchDelete(Collection<Long> disIdCollection);

    /**
     * 查询所有学科并分页
     * @param pagingDTO 自定义分页对象
     * @return
     */
    List<Discipline> listAll(PagingDTO pagingDTO);

    Discipline read(Long disId);
}
