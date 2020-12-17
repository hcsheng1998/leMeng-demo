package com.nhsoft.ledemo.controller;

import com.nhsoft.ledemo.dto.ResponseMessageDTO;
import com.nhsoft.ledemo.dto.TeacherDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Teacher;
import com.nhsoft.ledemo.service.TeacherDisciplineMappingService;
import com.nhsoft.ledemo.service.TeacherService;
import com.nhsoft.ledemo.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/11 : 9:04
 */
@Api(tags = "教师信息模块")
@RestController
@RequestMapping("/teacher/")
@Slf4j
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @Resource
    private TeacherDisciplineMappingService tdService;

    @ApiOperation("查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("listTeacherGradeByYears")
    public ResponseMessageDTO listTeacherGradeByYears(@ApiParam("封装参数:years和teaIdMp") TeacherDisciplineMpUidDTO sd) {

        log.info("接口的参数:" + sd);
        ResponseMessageDTO responseMessageDTO = null;

        List<TeacherGradeDTO> teacherGradeDTOS = tdService.listTeacherGradeDTO(sd);

        if (teacherGradeDTOS == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(teacherGradeDTOS);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询所有的教师,并分页")
    @PostMapping("listTeacher")
    public ResponseMessageDTO listTeacher(@ApiParam("封装教师分页信息,page,size") TeacherDTO teacher) {

        log.info("接口的参数:" + teacher);
        ResponseMessageDTO responseMessageDTO = null;

        List<Teacher> teachers = teacherService.listAll(teacher);

        if (teachers == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(teachers);

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询一个教师信息")
    @PostMapping("readTeacher")
    public ResponseMessageDTO readTeacher(@ApiParam("教师主键") Long teaId) {

        log.info("接口的参数:" + teaId);
        ResponseMessageDTO responseMessageDTO = null;

        Teacher teacher = teacherService.readById(teaId);

        if (teacher == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(teacher);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量保存或更新教师信息")
    @PostMapping("saveOrUpdateTeacher")
    public ResponseMessageDTO saveOrUpdateTeacher(@ApiParam("教师信息集合") @RequestParam("teachers") List<TeacherDTO> teachers) {

        log.info("接口的参数:" + teachers);
        ResponseMessageDTO responseMessageDTO = null;

        List<TeacherDTO> teacherDTOS = teacherService.batchSaveOrUpdate(teachers);

        if (teacherDTOS == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量删除教师信息")
    @PostMapping("deleteTeacher")
    public ResponseMessageDTO deleteTeacher(@ApiParam("教师主键") @RequestParam("teaIds") List<Long> teaIds) {

        log.info("接口的参数:" + teaIds);
        ResponseMessageDTO responseMessageDTO = null;

        List<Long> ids = teacherService.batchDelete(teaIds);

        if (ids == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }
}
