package com.nhsoft.ledemo.service;

import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Student;

import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/16 : 19:04
 */
public interface StudentService {

    List<Student> batchSaveOrUpdate(List<Student> studentList);

    List<Long> batchDelete(List<Long> stuIdList);

    Student readById(Long stuId);

    /**
     * 查询所有学生并分页
     * @param pagingDTO 自定义分页对象
     * @return
     */
    List<Student> listAll(PagingDTO pagingDTO);
}
