package com.nhsoft.ledemo.controller;

import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.dto.ResponseMessageDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.service.DisciplineService;
import com.nhsoft.ledemo.service.StudentDisciplineMappingService;
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
@Api(tags = "学科信息模块")
@RestController
@RequestMapping("/discipline/")
@Slf4j
public class DisciplineController {

    @Resource
    private DisciplineService disciplineService;

    @Resource
    private StudentDisciplineMappingService sdService;

    @ApiOperation("查询每学年学科平均成绩，最高分，最低分")
    @GetMapping("readDisciplineGradeByYears")
    public ResponseMessageDTO readDisciplineGradeByYears(@ApiParam("封装参数:years和disIdMp") StudentDisciplineMpUidDTO sd) {

        log.info("接口的参数:" + sd);
        ResponseMessageDTO responseMessageDTO = null;

        TeacherGradeDTO teacherGradeDTO = sdService.readTeacherGradeDTO(sd);

        if (teacherGradeDTO == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(teacherGradeDTO);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询所有的学科,并分页")
    @PostMapping("listDiscipline")
    public ResponseMessageDTO listDiscipline(@ApiParam("封装学科分页信息,page,size") DisciplineDTO discipline) {

        log.info("接口的参数:" + discipline);
        ResponseMessageDTO responseMessageDTO = null;

        List<Discipline> disciplines = disciplineService.listAll(discipline);

        if (disciplines == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(disciplines);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询一个学科信息")
    @PostMapping("readDiscipline")
    public ResponseMessageDTO readDiscipline(@ApiParam("学科主键") Long disId) {

        log.info("接口的参数:" + disId);
        ResponseMessageDTO responseMessageDTO = null;

        Discipline discipline = disciplineService.readById(disId);

        if (discipline == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(discipline);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量保存或更新学科信息")
    @PostMapping("saveOrUpdateDiscipline")
    public ResponseMessageDTO saveOrUpdateDiscipline(@ApiParam("学科集合") @RequestParam("disciplines") List<DisciplineDTO> disciplines) {

        log.info("接口的参数:" + disciplines);
        ResponseMessageDTO responseMessageDTO = null;

        List<DisciplineDTO> disciplineDTOS = disciplineService.batchSaveOrUpdate(disciplines);

        if (disciplineDTOS == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量删除学科信息")
    @PostMapping("deleteDiscipline")
    public ResponseMessageDTO deleteDiscipline(@ApiParam("学科主键集合") @RequestParam("disIds") List<Long> disIds) {

        log.info("接口的参数:" + disIds);
        ResponseMessageDTO responseMessageDTO = null;

        List<Long> ids = disciplineService.batchDelete(disIds);

        if (ids == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }
}
