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
        List<Student> toUpdateStudentList = studentList.stream()
                .filter(student -> set.isMember(RedisKeyConstant.STUDENT_SET, student.getStuNum()))
                .collect(Collectors.toList());

        List<Student> toSaveStudentList = studentList.stream()
                .filter(student -> !set.isMember(RedisKeyConstant.STUDENT_SET, student.getStuNum()))
                .collect(Collectors.toList());

        studentList = null;

        if (toUpdateStudentList.size() != 0) {
            studentList = (List<Student>) studentDao.batchSave(toUpdateStudentList);
        }

        if (toSaveStudentList.size() != 0) {
            studentList = (List<Student>) studentDao.batchUpdate(toSaveStudentList);
            //保存成功,学生学号放入redis的set中
            studentList.forEach(student -> set.add(RedisKeyConstant.STUDENT_SET, student.getStuNum()));
        }

        return studentList;
    }


    @Override
    public List<Long> batchDelete(List<Long> stuIdList) {

        if (stuIdList == null) {
            return null;
        }

        //删除成功,从redis中删除学号
        stuIdList.forEach(stuId -> {
            Student student = studentDao.readById(stuId);
            set.remove(RedisKeyConstant.STUDENT_SET, student.getStuNum());
        });

        stuIdList = (List<Long>) studentDao.batchDelete(stuIdList);

        return stuIdList;
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
