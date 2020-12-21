package com.nhsoft.ledemo.dao;

import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Student;

import java.util.Collection;
import java.util.List;

/**
 * @author hcsheng1998
 */
public interface StudentDao {

    Collection<Student> batchSave(Collection<Student> studentCollection);

    Collection<Student> batchUpdate(Collection<Student> studentCollection);

    Collection<Long> batchDelete(Collection<Long> stuIdCollection);

    /**
     * 查询所有学生并分页
     * @param pagingDTO 自定义分页对象
     * @return
     */
    List<Student> listAll(PagingDTO pagingDTO);

    Student read(Long stuId);
}
