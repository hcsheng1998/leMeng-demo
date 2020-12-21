package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.TeacherDisciplineMappingDao;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.model.uid.TeacherDisciplineMpUid;
import com.nhsoft.ledemo.service.TeacherDisciplineMappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hcsheng1998
 */
@Service
@Transactional
public class TeacherDisciplineMappingServiceImpl  implements TeacherDisciplineMappingService {

    @Resource
    private TeacherDisciplineMappingDao teacherDisciplineMappingDao;

    @Override
    public List<DisciplineGradeDTO> listDisciplineGrade(TeacherDisciplineMpUid teacherDisciplineMpUid) {

        if (teacherDisciplineMpUid == null) {
            return null;
        }

        return teacherDisciplineMappingDao.listDisciplineGrade(teacherDisciplineMpUid);
    }
}
