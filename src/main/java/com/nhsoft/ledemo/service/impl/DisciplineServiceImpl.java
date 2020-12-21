package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.DisciplineDao;
import com.nhsoft.ledemo.dto.PagingDTO;
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
 * @author hcsheng1998
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
    public List<Discipline> batchSaveOrUpdate(List<Discipline> disciplineList) {

        if (CollectionUtils.isEmpty(disciplineList)) {
            return null;
        }

        //利用redis进行学科编号过滤
        List<Discipline> toUpdateDisciplineList = disciplineList.stream()
                .filter(discipline -> set.isMember(RedisKeyConstant.DISCIPLINE_SET, discipline.getDisNum()))
                .collect(Collectors.toList());

        List<Discipline> toSaveDisciplineList = disciplineList.stream()
                .filter(discipline -> !set.isMember(RedisKeyConstant.DISCIPLINE_SET, discipline.getDisNum()))
                .collect(Collectors.toList());

        disciplineList = null;

        if (CollectionUtils.isEmpty(toSaveDisciplineList)) {
            disciplineList = (List<Discipline>) disciplineDao.batchSave(toSaveDisciplineList);

            //保存成功,学科编号放入redis的set中
            disciplineList.forEach(discipline -> set.add(RedisKeyConstant.DISCIPLINE_SET, discipline.getDisNum()));
        }

        if (CollectionUtils.isEmpty(toUpdateDisciplineList)) {
            disciplineList = (List<Discipline>) disciplineDao.batchUpdate(toUpdateDisciplineList);
        }

        return disciplineList;
    }


    @Override
    public List<Long> batchDelete(List<Long> disIdList) {

        if (CollectionUtils.isEmpty(disIdList)) {
            return null;
        }

        //删除成功,从redis中删除学科编号
        disIdList.forEach(disId -> {
            Discipline discipline = disciplineDao.read(disId);
            set.remove(RedisKeyConstant.DISCIPLINE_SET, discipline.getDisNum());
        });

        disIdList = (List<Long>) disciplineDao.batchDelete(disIdList);

        return disIdList;
    }

    @Override
    public Discipline read(Long disId) {

        if (disId == null) {
            return null;
        }

        return disciplineDao.read(disId);
    }

    @Override
    public List<Discipline> listAll(PagingDTO pagingDTO) {

        if (pagingDTO == null) {
            return null;
        }

        return disciplineDao.listAll(pagingDTO);
    }
}
