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
 * @author hcsheng1998
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
        List<Teacher> toUpdateTeacherList = teacherList.stream()
                .filter(teacher -> set.isMember(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum()))
                .collect(Collectors.toList());

        List<Teacher> toSaveTeacherList = teacherList.stream()
                .filter(teacher -> !set.isMember(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum()))
                .collect(Collectors.toList());

        teacherList = null;

        if (CollectionUtils.isEmpty(toSaveTeacherList)) {
            teacherList = (List<Teacher>) teacherDao.batchSave(toSaveTeacherList);

            //保存成功,老师编号放入redis的set中
            teacherList.forEach(teacher -> set.add(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum()));
        }

        if (CollectionUtils.isEmpty(toUpdateTeacherList)) {
            teacherList = (List<Teacher>) teacherDao.batchUpdate(toUpdateTeacherList);
        }

        return teacherList;
    }


    @Override
    public List<Long> batchDelete(List<Long> teaIdList) {

        if (CollectionUtils.isEmpty(teaIdList)) {
            return null;
        }

        //删除成功,从redis中删除老师编号
        teaIdList.forEach(teaId -> {
            Teacher teacher = teacherDao.read(teaId);
            set.remove(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum());
        });

        teaIdList = (List<Long>) teacherDao.batchDelete(teaIdList);

        return teaIdList;
    }

    @Override
    public Teacher read(Long teaId) {

        if (teaId == null) {
            return null;
        }

        return teacherDao.read(teaId);
    }

    @Override
    public List<Teacher> listAll(PagingDTO pagingDTO) {

        if (pagingDTO == null) {
            return null;
        }

        return teacherDao.listAll(pagingDTO);
    }

}
