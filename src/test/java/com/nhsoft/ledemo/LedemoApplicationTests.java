package com.nhsoft.ledemo;

import com.nhsoft.ledemo.dao.DisciplineDao;
import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.model.Student;
import com.nhsoft.ledemo.model.StudentDisciplineMapping;
import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;
import com.nhsoft.ledemo.service.DisciplineService;
import com.nhsoft.ledemo.service.StudentService;
import com.nhsoft.ledemo.util.CopyUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class LedemoApplicationTests {

    @Resource
    private DisciplineDao disciplineDao;

    @Resource
    DisciplineService disciplineService;

    @Resource
    StudentService studentService;

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

    @Test
    void test4() {
        Student student = new Student();
        student.setStuNum("007");
        student.setStuName("007");
        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        List<Student> studentList = studentService.batchSaveOrUpdate(students);



        Discipline discipline = new Discipline();
        discipline.setDisNum("008");
        discipline.setDisName("008");
        StudentDisciplineMapping studentDisciplineMapping = new StudentDisciplineMapping();
        studentDisciplineMapping.setGrade(new BigDecimal(80));
        studentDisciplineMapping.setDiscipline(discipline);
        StudentDisciplineMpUid studentDisciplineMpUid = new StudentDisciplineMpUid();
        studentDisciplineMpUid.setSemester((short) 1);
        studentDisciplineMpUid.setYears("2026");
        studentDisciplineMapping.setStudentDisciplineMpUid(studentDisciplineMpUid);
        HashSet<StudentDisciplineMapping> disciplines = new HashSet<>();
        disciplines.add(studentDisciplineMapping);



    }

    @Test
    void  test5() {

        ArrayList<Long> longs = new ArrayList<>();
        longs.add(26L);
        studentService.batchDelete(longs);
    }
}
