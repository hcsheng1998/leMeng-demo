package com.nhsoft.ledemo.controller;

import com.nhsoft.ledemo.dto.ResponseMessageDTO;
import com.nhsoft.ledemo.dto.TeacherDTO;
import com.nhsoft.ledemo.dto.TeacherGradeDTO;
import com.nhsoft.ledemo.dto.uid.TeacherDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Teacher;
import com.nhsoft.ledemo.service.TeacherService;
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
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/11 : 9:04
 */
@Api(tags = "教师信息模块")
@RestController
@RequestMapping("/teacher/")
@Log
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @ApiOperation("查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("listTeacherGradeByYears")
    public ResponseMessageDTO listTeacherGradeByYears(@ApiParam("封装参数:years和teaIdMp") TeacherDisciplineMpUidDTO sd) {

        log.info("接口的参数:" + sd);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = sd.getYears() == null || sd.getTeaIdMp() == null;
        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        List<TeacherGradeDTO> teacherGradeDTOS = teacherService.listTeacherGradeDTO(sd);

        //查询是否成功
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

        boolean dataFalse = teacher.getSize() == 0;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        Page pageTeacher = teacherService.list(teacher);

        //保存或更新是否成功
        if (pageTeacher == null) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc(pageTeacher);

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询一个教师信息")
    @PostMapping("readTeacher")
    public ResponseMessageDTO readTeacher(@ApiParam("封装教师主键,teaId") TeacherDTO teacherPo) {

        log.info("接口的参数:" + teacherPo);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = teacherPo.getTeaId() == null;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        Teacher teacher = teacherService.read(teacherPo);

        //保存或更新是否成功
        if (teacher == null) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc(teacher);

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("保存或更新一个教师信息")
    @PostMapping("saveOrUpdateTeacher")
    public ResponseMessageDTO saveOrUpdateTeacher(@ApiParam("封装教师信息类,teaId,teaName,teaNum") Teacher teacher) {

        log.info("接口的参数:" + teacher);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = teacher.getTeaName() == null || teacher.getTeaNum() == null;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        boolean b = teacherService.saveOrUpdate(teacher);

        //保存或更新是否成功
        if (!b) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc();

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("删除一个教师信息")
    @PostMapping("deleteTeacher")
    public ResponseMessageDTO deleteTeacher(@ApiParam("封装教师主键,teaId") TeacherDTO teacher) {

        log.info("接口的参数:" + teacher);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = teacher.getTeaId() == null;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        boolean b = teacherService.delete(teacher);

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
