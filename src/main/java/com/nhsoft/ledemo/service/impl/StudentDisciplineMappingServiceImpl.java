package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.StudentDisciplineMappingDao;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;
import com.nhsoft.ledemo.service.StudentDisciplineMappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hcsheng1998
 */
@Service
@Transactional
public class StudentDisciplineMappingServiceImpl implements StudentDisciplineMappingService {

    @Resource
    private StudentDisciplineMappingDao studentDisciplineMappingDao;

    @Override
    public List<DisciplineGradeDTO> listDisciplineGrade(StudentDisciplineMpUid studentDisciplineMpUid){

        if (studentDisciplineMpUid == null) {
            return null;
        }

        return studentDisciplineMappingDao.listDisciplineGrade(studentDisciplineMpUid);
    }

    @Override
    public DisciplineGradeDTO readDisciplineGrade(StudentDisciplineMpUid studentDisciplineMpUid) {

        if (studentDisciplineMpUid == null) {
            return null;
        }

        return studentDisciplineMappingDao.readDisciplineGrade(studentDisciplineMpUid);
    }
}
