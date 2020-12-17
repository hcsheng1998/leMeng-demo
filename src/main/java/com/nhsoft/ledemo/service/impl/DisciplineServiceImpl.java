package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.DisciplineDao;
import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.service.DisciplineService;
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
 * @date 2020/12/10 : 15:24
 */
@Service
@Transactional
public class DisciplineServiceImpl implements DisciplineService {

    @Resource
    private DisciplineDao disciplineDao;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> set;

    @Override
    public List<DisciplineDTO> batchSaveOrUpdate(List<DisciplineDTO> disciplines) {

        if (CollectionUtils.isEmpty(disciplines)) {
            return null;
        }

        //利用redis进行学科编号过滤
        List<DisciplineDTO> toUpdateDisciplines = disciplines.stream()
                .filter(discipline -> set.isMember(RedisKeyConstant.DISCIPLINE_SET, discipline.getDisNum()))
                .collect(Collectors.toList());

        List<DisciplineDTO> toSaveDisciplines = disciplines.stream()
                .filter(discipline -> !set.isMember(RedisKeyConstant.DISCIPLINE_SET, discipline.getDisNum()))
                .collect(Collectors.toList());

        List<DisciplineDTO> list = null;

        if (toSaveDisciplines != null) {
            list = (List<DisciplineDTO>) disciplineDao.batchSave(toSaveDisciplines);
        }

        if (toUpdateDisciplines != null) {
            list = (List<DisciplineDTO>) disciplineDao.batchUpdate(toUpdateDisciplines);
        }

        return list;
    }


    @Override
    public List<Long> batchDelete(List<Long> disIds) {

        if (disIds == null) {
            return null;
        }

        return (List<Long>) disciplineDao.batchDelete(disIds);
    }

    @Override
    public Discipline readById(Long disId) {

        if (disId == null) {
            return null;
        }

        return disciplineDao.readById(disId);
    }

    @Override
    public List<Discipline> listAll(DisciplineDTO discipline) {

        if (discipline == null) {
            return null;
        }

        return disciplineDao.listAll(discipline);
    }
}
