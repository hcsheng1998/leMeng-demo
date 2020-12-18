package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.TeacherDao;
import com.nhsoft.ledemo.dto.PagingDTO;
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
    public List<Teacher> batchSaveOrUpdate(List<Teacher> teacherList) {

        if (CollectionUtils.isEmpty(teacherList)) {
            return null;
        }

        //利用redis进行num过滤
        List<Teacher> toUpdateTeachers = teacherList.stream()
                .filter(teacher -> set.isMember(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum()))
                .collect(Collectors.toList());

        List<Teacher> toSaveTeachers = teacherList.stream()
                .filter(teacher -> !set.isMember(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum()))
                .collect(Collectors.toList());

        teacherList = null;

        if (toSaveTeachers != null) {
            teacherList = (List<Teacher>) teacherDao.batchSave(toSaveTeachers);
        }

        if (toUpdateTeachers != null) {
            teacherList = (List<Teacher>) teacherDao.batchUpdate(toUpdateTeachers);
        }

        return teacherList;
    }


    @Override
    public List<Long> batchDelete(List<Long> teaIdList) {

        if (teaIdList == null) {
            return null;
        }

        return (List<Long>) teacherDao.batchDelete(teaIdList);
    }

    @Override
    public Teacher readById(Long teaId) {

        if (teaId == null) {
            return null;
        }

        return teacherDao.readById(teaId);
    }

    @Override
    public List<Teacher> listAll(PagingDTO pagingDTO) {

        if (pagingDTO == null) {
            return null;
        }

        return teacherDao.listAll(pagingDTO);
    }

}
