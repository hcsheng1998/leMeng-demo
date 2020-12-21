package com.nhsoft.ledemo.controller;

import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.dto.ResponseMessageDTO;
import com.nhsoft.ledemo.dto.TeacherDTO;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Teacher;
import com.nhsoft.ledemo.model.uid.TeacherDisciplineMpUid;
import com.nhsoft.ledemo.service.TeacherDisciplineMappingService;
import com.nhsoft.ledemo.service.TeacherService;
import com.nhsoft.ledemo.util.CopyUtil;
import com.nhsoft.ledemo.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hcsheng1998
 */
@Slf4j
@Api(tags = "教师信息模块")
@RestController
@RequestMapping("/teacher/")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @Resource
    private TeacherDisciplineMappingService teacherDisciplineMappingService;

    @ApiOperation("查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("listTeacherGrade")
    public ResponseMessageDTO listTeacherGrade(@ApiParam("封装参数:years和teaIdMp") TeacherDisciplineMpUidDTO teacherDisciplineMpUidDTO) {

        log.info("接口的参数:" + teacherDisciplineMpUidDTO);
        ResponseMessageDTO responseMessageDTO = null;

        List<DisciplineGradeDTO> disciplineGradeDTOList = teacherDisciplineMappingService.listDisciplineGrade(CopyUtil.to(teacherDisciplineMpUidDTO, TeacherDisciplineMpUid.class));

        if (disciplineGradeDTOList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(disciplineGradeDTOList);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询所有的教师,并分页")
    @PostMapping("list")
    public ResponseMessageDTO listAll(@ApiParam("分页信息,page,size") PagingDTO pagingDTO) {

        log.info("接口的参数:" + pagingDTO);
        ResponseMessageDTO responseMessageDTO = null;

        List<Teacher> teacherList = teacherService.listAll(pagingDTO);

        if (teacherList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(CopyUtil.toList(teacherList, TeacherDTO.class));

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询一个教师信息")
    @PostMapping("read")
    public ResponseMessageDTO read(@ApiParam("教师主键") Long teaId) {

        log.info("接口的参数:" + teaId);
        ResponseMessageDTO responseMessageDTO = null;

        Teacher teacher = teacherService.read(teaId);

        if (teacher == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(CopyUtil.to(teacher, TeacherDTO.class));
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量保存或更新教师信息")
    @PostMapping("saveOrUpdate")
    public ResponseMessageDTO saveOrUpdate(@ApiParam("教师信息集合") @RequestParam("teacherDTOList") List<TeacherDTO> teacherDTOList) {

        log.info("接口的参数:" + teacherDTOList);
        ResponseMessageDTO responseMessageDTO = null;

        List<Teacher> teacherList = teacherService.batchSaveOrUpdate(CopyUtil.toList(teacherDTOList, Teacher.class));

        if (teacherList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量删除教师信息")
    @PostMapping("delete")
    public ResponseMessageDTO delete(@ApiParam("教师主键") @RequestParam("teaIdList") List<Long> teaIdList) {

        log.info("接口的参数:" + teaIdList);
        ResponseMessageDTO responseMessageDTO = null;

        teaIdList = teacherService.batchDelete(teaIdList);

        if (teaIdList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }
}
