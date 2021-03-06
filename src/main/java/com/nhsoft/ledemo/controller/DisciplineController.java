package com.nhsoft.ledemo.controller;

import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.dto.ResponseMessageDTO;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;
import com.nhsoft.ledemo.service.DisciplineService;
import com.nhsoft.ledemo.service.StudentDisciplineMappingService;
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
@Api(tags = "学科信息模块")
@RestController
@RequestMapping("/discipline/")
public class DisciplineController {

    @Resource
    private DisciplineService disciplineService;

    @Resource
    private StudentDisciplineMappingService studentDisciplineMappingService;

    @ApiOperation("查询每学年学科平均成绩，最高分，最低分")
    @GetMapping("readDisciplineGrade")
    public ResponseMessageDTO readDisciplineGrade(@ApiParam("封装参数:years和disIdMp") StudentDisciplineMpUidDTO studentDisciplineMpUidDTO) {

        log.info("接口的参数:" + studentDisciplineMpUidDTO);
        ResponseMessageDTO responseMessageDTO = null;

        DisciplineGradeDTO disciplineGradeDTO = studentDisciplineMappingService.readDisciplineGrade(CopyUtil.to(studentDisciplineMpUidDTO, StudentDisciplineMpUid.class));

        if (disciplineGradeDTO == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(disciplineGradeDTO);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询所有的学科,并分页")
    @PostMapping("list")
    public ResponseMessageDTO listAll(@ApiParam("分页信息,page,size") PagingDTO pagingDTO) {

        log.info("接口的参数:" + pagingDTO);
        ResponseMessageDTO responseMessageDTO = null;

        List<Discipline> disciplineList = disciplineService.listAll(pagingDTO);

        if (disciplineList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(CopyUtil.toList(disciplineList, DisciplineDTO.class));
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询一个学科信息")
    @PostMapping("read")
    public ResponseMessageDTO read(@ApiParam("学科主键") Long disId) {

        log.info("接口的参数:" + disId);
        ResponseMessageDTO responseMessageDTO = null;

        Discipline discipline = disciplineService.read(disId);

        if (discipline == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(CopyUtil.to(discipline, DisciplineDTO.class));
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量保存或更新学科信息")
    @PostMapping("saveOrUpdate")
    public ResponseMessageDTO saveOrUpdate(@ApiParam("学科集合") @RequestParam("disciplineDTOList") List<DisciplineDTO> disciplineDTOList) {

        log.info("接口的参数:" + disciplineDTOList);
        ResponseMessageDTO responseMessageDTO = null;

        List<Discipline> disciplineList = disciplineService.batchSaveOrUpdate(CopyUtil.toList(disciplineDTOList, Discipline.class));

        if (disciplineList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量删除学科信息")
    @PostMapping("delete")
    public ResponseMessageDTO delete(@ApiParam("学科主键集合") @RequestParam("disIdList") List<Long> disIdList) {

        log.info("接口的参数:" + disIdList);
        ResponseMessageDTO responseMessageDTO = null;

        disIdList = disciplineService.batchDelete(disIdList);

        if (disIdList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }
}
