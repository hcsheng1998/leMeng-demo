package com.nhsoft.ledemo;

import com.nhsoft.ledemo.dao.DisciplineDao;
import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.service.DisciplineService;
import com.nhsoft.ledemo.util.CopyUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@Transactional
@Rollback(value = false)
class LedemoApplicationTests {

    @Resource
    private DisciplineDao disciplineDao;

    @Resource
    DisciplineService disciplineService;


    @Test
    void test2() {

        Discipline discipline = disciplineService.readById(1L);
        DisciplineDTO disciplineDTO = CopyUtil.to(discipline, DisciplineDTO.class);
        System.out.println(disciplineDTO);
    }

    @Test
    void test3() {

        Discipline discipline = disciplineDao.readById(1L);
        System.out.println(discipline);
    }
}
