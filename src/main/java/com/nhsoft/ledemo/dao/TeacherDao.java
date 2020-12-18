package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Teacher;

import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface TeacherDao {
    
    Collection<Teacher> batchSave(Collection<Teacher> teacherCollection);

    Collection<Teacher> batchUpdate(Collection<Teacher> teacherCollection);

    Collection<Long> batchDelete(Collection<Long> teaIdCollection);

    /**
     * 查询所有老师并分页
     * @param pagingDTO 自定义分页对象
     * @return
     */
    List<Teacher> listAll(PagingDTO pagingDTO);

    Teacher readById(Long teaId);
    
}
