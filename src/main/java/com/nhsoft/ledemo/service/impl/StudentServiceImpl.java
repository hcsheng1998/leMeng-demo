package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.StudentDao;
import com.nhsoft.ledemo.dto.StudentDTO;
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
    public List<StudentDTO> batchSaveOrUpdate(List<StudentDTO> students) {

        if (CollectionUtils.isEmpty(students)) {
            return null;
        }

        //利用redis进行学号重复过滤
        List<StudentDTO> toUpdateStudents = students.stream()
                .filter(student -> set.isMember(RedisKeyConstant.STUDENT_SET, student.getStuNum()))
                .collect(Collectors.toList());

        List<StudentDTO> toSaveStudents = students.stream()
                .filter(student -> !set.isMember(RedisKeyConstant.STUDENT_SET, student.getStuNum()))
                .collect(Collectors.toList());

        List<StudentDTO> list = null;

        if (toSaveStudents != null) {
            list = (List<StudentDTO>) studentDao.batchSave(toSaveStudents);
        }

        if (toUpdateStudents != null) {
            list = (List<StudentDTO>) studentDao.batchUpdate(toUpdateStudents);
        }

        return list;
    }


    @Override
    public List<Long> batchDelete(List<Long> stuIds) {

        if (stuIds == null) {
            return null;
        }

        return (List<Long>) studentDao.batchDelete(stuIds);
    }

    @Override
    public Student readById(Long stuId) {

        return studentDao.readById(stuId);
    }

    @Override
    public List<Student> listAll(StudentDTO student) {

        if (student == null) {
            return null;
        }

        return studentDao.listAll(student);
    }
}
