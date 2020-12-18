package com.nhsoft.ledemo;

import com.nhsoft.ledemo.dao.DisciplineDao;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.service.DisciplineService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

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

        ArrayList<Long> disIds = new ArrayList<>();
        disIds.add(7L);
        disIds.add(4L);


        Collection<Long> longs = disciplineDao.batchDelete(disIds);
        longs.forEach(System.out::println);
    }

    @Test
    void test3() {

        Discipline discipline = disciplineDao.readById(1L);
        System.out.println(discipline);
    }
}
