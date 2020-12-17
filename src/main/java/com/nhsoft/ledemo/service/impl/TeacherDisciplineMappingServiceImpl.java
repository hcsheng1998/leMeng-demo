package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.TeacherDisciplineMappingDao;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;
import com.nhsoft.ledemo.service.TeacherDisciplineMappingService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/17 : 22:42
 */
public class TeacherDisciplineMappingServiceImpl  implements TeacherDisciplineMappingService {

    @Resource
    private TeacherDisciplineMappingDao tdRepo;

    @Override
    public List<TeacherGradeDTO> listTeacherGradeDTO(TeacherDisciplineMpUidDTO td) {

        if (td == null) {
            return null;
        }

        return tdRepo.listTeacherGradeDTO(td);
    }
}
