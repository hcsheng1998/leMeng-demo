package com.nhsoft.ledemo;

import com.nhsoft.ledemo.dao.DisciplineDao;
import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.service.DisciplineService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class LedemoApplicationTests {

    @Resource
    private DisciplineDao disciplineDao;

    @Resource
    DisciplineService disciplineService;

    @Test
    void contextLoads() {

        DisciplineDTO disciplineDTO = new DisciplineDTO();
        disciplineDTO.setPage(0);
        disciplineDTO.setSize(2);
        List<Discipline> disciplines = disciplineService.listAll(disciplineDTO);
        disciplines.forEach(discipline -> System.err.println(discipline));
    }

    @Test
    void test1() {

        ArrayList<DisciplineDTO> disciplinesList = new ArrayList<>();
        DisciplineDTO discipline = new DisciplineDTO();
        discipline.setDisId(7L);
        discipline.setDisName("l7");
        discipline.setDisNum("009");
        disciplinesList.add(discipline);

        Collection<DisciplineDTO> disciplines = disciplineDao.batchUpdate(disciplinesList);
        disciplines.forEach(discipline1 -> System.out.println(discipline1));
    }

    @Test
    void test2() {

        ArrayList<Long> disIds = new ArrayList<>();
        disIds.add(7L);
        disIds.add(4L);


        Collection<Long> longs = disciplineDao.batchDelete(disIds);
        longs.forEach(discipline1 -> System.out.println(discipline1));
    }

    @Test
    void test3() {

        Discipline discipline = disciplineDao.readById(1L);
        System.out.println(discipline);
    }
}
