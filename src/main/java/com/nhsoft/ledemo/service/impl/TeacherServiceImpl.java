package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.TeacherDao;
import com.nhsoft.ledemo.dto.TeacherDTO;
import com.nhsoft.ledemo.model.Teacher;
import com.nhsoft.ledemo.service.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherDao teacherDao;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> set;

    @Override
    public List<TeacherDTO> batchSaveOrUpdate(List<TeacherDTO> teachers) {

        if (CollectionUtils.isEmpty(teachers)) {
            return null;
        }

        //利用redis进行num过滤
        List<TeacherDTO> toUpdateTeachers = teachers.stream()
                .filter(teacher -> set.isMember(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum()))
                .collect(Collectors.toList());

        List<TeacherDTO> toSaveTeachers = teachers.stream()
                .filter(teacher -> !set.isMember(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum()))
                .collect(Collectors.toList());

        List<TeacherDTO> list = null;

        if (toSaveTeachers != null) {
            list = (List<TeacherDTO>) teacherDao.batchSave(toSaveTeachers);
        }

        if (toUpdateTeachers != null) {
            list = (List<TeacherDTO>) teacherDao.batchUpdate(toUpdateTeachers);
        }

        return list;
    }


    @Override
    public List<Long> batchDelete(List<Long> teaIds) {

        if (teaIds == null) {
            return null;
        }

        return (List<Long>) teacherDao.batchDelete(teaIds);
    }

    @Override
    public Teacher readById(Long teaId) {

        if (teaId == null) {
            return null;
        }

        return teacherDao.readById(teaId);
    }

    @Override
    public List<Teacher> listAll(TeacherDTO teacher) {

        if (teacher == null) {
            return null;
        }

        return teacherDao.listAll(teacher);
    }

}
