package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.outdao.TeacherDao;
import com.nhsoft.ledemo.dao.outdao.TeacherDisciplineMappingDao;
import com.nhsoft.ledemo.dto.TeacherDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Teacher;
import com.nhsoft.ledemo.service.TeacherService;
import com.nhsoft.ledemo.util.RedisKeyConstant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 14:54
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherDao teacherDao;

    @Resource
    private TeacherDisciplineMappingDao tdRepo;
    @Resource
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> set;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(Teacher teacher) {

        try {
            //判断是更改操作还是保存操作
            //保存操作需要判断编号是否唯一
            if (teacher.getTeaId() == null) {

                //保存操作判断老师编号是否存在
                if (set.isMember(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum())) {

                    return false;
                }
            }

            Teacher save = teacherDao.save(teacher);

            //判断插入成功后将老师编号存入redis中
            if (save != null) {

                set.add(RedisKeyConstant.TEACHER_SET, teacher.getTeaNum());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(TeacherDTO teacher) {

        boolean b = true;
        try {
            teacherDao.deleteById(teacher.getTeaId());
        } catch (Exception e) {
            b = false;
        } finally {
            return b;
        }
    }

    @Override
    public Teacher read(TeacherDTO teacher) {

        Specification<Teacher> specification = (Specification<Teacher>) (root, criteriaQuery, criteriaBuilder) -> {

            Path<Object> teaId = root.get("teaId");
            return criteriaBuilder.equal(teaId, teacher.getTeaId());
        };
        return teacherDao.findOne(specification).get();
    }

    @Override
    public Page list(TeacherDTO teacher) {


        PageRequest re = PageRequest.of(teacher.getPage(), teacher.getSize());

        return teacherDao.findAll(re);

    }

    @Override
    public List<TeacherGradeDTO> listTeacherGradeDTO(TeacherDisciplineMpUidDTO td) {

        return tdRepo.listTeacherGradeDTO(td.getTeaIdMp(),
                td.getYears());
    }
}
