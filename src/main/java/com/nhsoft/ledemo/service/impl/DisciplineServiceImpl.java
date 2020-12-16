package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.outdao.DisciplineDao;
import com.nhsoft.ledemo.dao.outdao.StudentDisciplineDao;
import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.Uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.service.DisciplineService;
import com.nhsoft.ledemo.util.RedisKeyConstant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 15:24
 */
@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Resource
    private DisciplineDao disciplineDao;

    @Resource
    private StudentDisciplineDao sdRepo;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> set;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(Discipline discipline) {

        try {

            //判断是更改操作还是保存操作
            //保存操作需要判断编号是否唯一
            if (discipline.getDisId() == null) {

                //判断学科编号是否存在
                if (set.isMember(RedisKeyConstant.DISCIPLINE_SET, discipline.getDisNum())) {

                    return false;
                }
            }

            Discipline save = disciplineDao.save(discipline);

            //判断插入成功后将学科编号存入redis中
            if (save != null) {

                set.add(RedisKeyConstant.DISCIPLINE_SET, discipline.getDisNum());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }


    @Override
    public boolean delete(DisciplineDTO discipline) {

        boolean b = true;
        try {
            disciplineDao.deleteById(discipline.getDisId());
        } catch (Exception e) {
            b = false;
        } finally {
            return b;
        }
    }

    @Override
    public Discipline read(DisciplineDTO discipline) {

        Specification<Discipline> disId = (Specification<Discipline>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("disId"), discipline.getDisId());
        return disciplineDao.findOne(disId).get();
    }

    @Override
    public Page list(DisciplineDTO discipline) {


        PageRequest re = PageRequest.of(discipline.getPage(), discipline.getSize());

        return disciplineDao.findAll(re);
    }

    @Override
    public TeacherGradeDTO readTeacherGradeDTO(StudentDisciplineMpUidDTO sd) {

        return sdRepo.readTeacherGradeDTO(sd.getDisIdMp(),
                sd.getYears());
    }
}
