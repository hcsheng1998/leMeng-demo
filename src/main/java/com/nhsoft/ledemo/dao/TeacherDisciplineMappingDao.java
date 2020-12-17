package com.nhsoft.ledemo.dao;
import com.nhsoft.ledemo.dto.TeacherDisciplineMappingDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;
import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/9 : 15:24
 */
public interface TeacherDisciplineMappingDao {

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     * @return
     */
    public List<TeacherGradeDTO> listTeacherGradeDTO(TeacherDisciplineMpUidDTO td);

    Collection<TeacherDisciplineMappingDTO> batchSave(Collection<TeacherDisciplineMappingDTO> collection);

    Collection<TeacherDisciplineMappingDTO> batchUpdate(Collection<TeacherDisciplineMappingDTO> collection);
}
