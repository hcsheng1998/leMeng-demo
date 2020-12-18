package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.StudentDao;
import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Student;
import com.nhsoft.ledemo.service.StudentService;
import com.nhsoft.ledemo.util.RedisKeyConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 14:54
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> set;


    @Override
    public List<Student> batchSaveOrUpdate(List<Student> studentList) {

        if (CollectionUtils.isEmpty(studentList)) {
            return null;
        }

        //利用redis进行学号重复过滤
        List<Student> toUpdateStudents = studentList.stream()
                .filter(student -> set.isMember(RedisKeyConstant.STUDENT_SET, student.getStuNum()))
                .collect(Collectors.toList());

        List<Student> toSaveStudents = studentList.stream()
                .filter(student -> !set.isMember(RedisKeyConstant.STUDENT_SET, student.getStuNum()))
                .collect(Collectors.toList());

        studentList = null;

        if (toSaveStudents != null) {
            studentList = (List<Student>) studentDao.batchSave(toSaveStudents);
        }

        if (toUpdateStudents != null) {
            studentList = (List<Student>) studentDao.batchUpdate(toUpdateStudents);
        }

        return studentList;
    }


    @Override
    public List<Long> batchDelete(List<Long> stuIdList) {

        if (stuIdList == null) {
            return null;
        }

        return (List<Long>) studentDao.batchDelete(stuIdList);
    }

    @Override
    public Student readById(Long stuId) {

        return studentDao.readById(stuId);
    }

    @Override
    public List<Student> listAll(PagingDTO pagingDTO) {

        if (pagingDTO == null) {
            return null;
        }

        return studentDao.listAll(pagingDTO);
    }
}
