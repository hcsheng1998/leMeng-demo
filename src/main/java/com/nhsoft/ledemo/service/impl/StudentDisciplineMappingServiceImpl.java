package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.StudentDisciplineMappingDao;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.service.StudentDisciplineMappingService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/17 : 22:40
 */
public class StudentDisciplineMappingServiceImpl implements StudentDisciplineMappingService {

    @Resource
    private StudentDisciplineMappingDao sdDao;

    @Override
    public List<DisciplineGradeDTO> listDisciplineGradeDTO(StudentDisciplineMpUidDTO sd){

        if (sd == null) {
            return null;
        }

        List<DisciplineGradeDTO> disciplineGradeDTOS = sdDao.listDisciplineGradeDTO(sd);
        return disciplineGradeDTOS;
    }

    @Override
    public TeacherGradeDTO readTeacherGradeDTO(StudentDisciplineMpUidDTO sd) {

        if (sd == null) {
            return null;
        }

        return sdDao.readTeacherGradeDTO(sd);
    }
}
