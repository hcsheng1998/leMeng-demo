package com.nhsoft.ledemo.controller;

import com.nhsoft.ledemo.dto.DisciplineDTO;
import com.nhsoft.ledemo.dto.ResponseMessageDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Discipline;
import com.nhsoft.ledemo.service.DisciplineService;
import com.nhsoft.ledemo.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author heChangSheng
 * @date 2020/12/11 : 9:04
 */
@Api(tags = "学科信息模块")
@RestController
@RequestMapping("/discipline/")
@Log
public class DisciplineController {

    @Resource
    private DisciplineService disciplineService;

    @ApiOperation("查询每学年学科平均成绩，最高分，最低分")
    @GetMapping("readDisciplineGradeByYears")
    public ResponseMessageDTO readDisciplineGradeByYears(@ApiParam("封装参数:years和disIdMp") StudentDisciplineMpUidDTO sd) {

        log.info("接口的参数:" + sd);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = sd.getYears() == null || sd.getDisIdMp() == null;
        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        TeacherGradeDTO teacherGradeDTO = disciplineService.readTeacherGradeDTO(sd);

        //查询是否成功
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

        boolean dataFalse = discipline.getSize() == 0;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        Page pageDiscipline = disciplineService.list(discipline);

        //保存或更新是否成功
        if (pageDiscipline == null) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc(pageDiscipline);

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询一个学科信息")
    @PostMapping("readDiscipline")
    public ResponseMessageDTO readDiscipline(@ApiParam("封装学科主键,disId") DisciplineDTO disciplinePo) {

        log.info("接口的参数:" + disciplinePo);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = disciplinePo.getDisId() == null;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        Discipline discipline = disciplineService.read(disciplinePo);

        //保存或更新是否成功
        if (discipline == null) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc(discipline);

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("保存或更新一个学科信息")
    @PostMapping("saveOrUpdateDiscipline")
    public ResponseMessageDTO saveOrUpdateDiscipline(@ApiParam("封装学科信息类,disId,disName,disNum") Discipline discipline) {

        log.info("接口的参数:" + discipline);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = discipline.getDisName() == null || discipline.getDisNum() == null;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        boolean b = disciplineService.saveOrUpdate(discipline);

        //保存或更新是否成功
        if (!b) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc();

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("删除一个学科信息")
    @PostMapping("deleteDiscipline")
    public ResponseMessageDTO deleteDiscipline(@ApiParam("封装学科主键,disId") DisciplineDTO discipline) {

        log.info("接口的参数:" + discipline);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = discipline.getDisId() == null;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        boolean b = disciplineService.delete(discipline);

        //删除是否成功
        if (!b) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc();

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }
}
