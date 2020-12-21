package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Teacher;

import java.util.List;

/**
 * @author hcsheng1998
 */
public interface TeacherService {

    List<Teacher> batchSaveOrUpdate(List<Teacher> teacherList);

    List<Long> batchDelete(List<Long> teaIdList);

    Teacher read(Long teaId);

    /**
     * 查询所有老师并分页
     * @param pagingDTO 自定义分页对象
     * @return
     */
    List<Teacher> listAll(PagingDTO pagingDTO);
}
