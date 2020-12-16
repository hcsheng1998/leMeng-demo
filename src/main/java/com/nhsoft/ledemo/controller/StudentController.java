package com.nhsoft.ledemo.controller;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.ResponseMessageDTO;
import com.nhsoft.ledemo.dto.StudentDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Student;
import com.nhsoft.ledemo.service.StudentService;
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
 * @date 2020/12/11 : 0:10
 */
@Api(tags = "学生信息模块")
@RestController
@RequestMapping("/student/")
@Log
public class StudentController {

    @Resource
    private StudentService studentService;

    @ApiOperation("学生查询本人每学年各学科成绩接口")
    @GetMapping("listSubjectGradeByYears")
    public ResponseMessageDTO listSubjectGradeByYears(@ApiParam("封装参数:years和stuIdMp") StudentDisciplineMpUidDTO sd) {

        log.info("接口的参数:" + sd);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = sd.getYears() == null || sd.getStuIdMp() == null;
        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        List<DisciplineGradeDTO> disciplineGradeDTOS = studentService.listDisciplineGradeDTO(sd);

        //查询是否成功
        if (disciplineGradeDTOS == null) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc(disciplineGradeDTOS);

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询所有的学生,并分页")
    @PostMapping("listStudent")
    public ResponseMessageDTO listStudent(@ApiParam("封装学生分页信息,page,size") StudentDTO student) {

        log.info("接口的参数:" + student);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = student.getSize() == 0;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        Page pageStudent = studentService.list(student);

        //保存或更新是否成功
        if (pageStudent == null) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc(pageStudent);

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询一个学生信息")
    @PostMapping("readStudent")
    public ResponseMessageDTO readStudent(@ApiParam("封装学生主键,stuId") StudentDTO studentPo) {

        log.info("接口的参数:" + studentPo);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = studentPo.getStuId() == null;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        Student student = studentService.read(studentPo);

        //保存或更新是否成功
        if (student == null) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc(student);

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("保存或更新一个学生信息")
    @PostMapping("saveOrUpdateStudent")
    public ResponseMessageDTO saveOrUpdateStudent(@ApiParam("封装学生信息类,stuId,stuName,stuNum") Student student) {

        log.info("接口的参数:" + student);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = student.getStuName() == null || student.getStuNum() == null;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        boolean b = studentService.saveOrUpdate(student);

        //保存或更新是否成功
        if (!b) {

            responseMessageDTO = ResponseUtil.opeFail();
        } else {

            responseMessageDTO = ResponseUtil.opeSuc();

        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("删除一个学生信息")
    @PostMapping("deleteStudent")
    public ResponseMessageDTO deleteStudent(@ApiParam("封装学生主键,stuId") StudentDTO student) {

        log.info("接口的参数:" + student);
        ResponseMessageDTO responseMessageDTO = null;

        boolean dataFalse = student.getStuId() == null;

        //检验前端数据
        if (dataFalse) {

            return ResponseUtil.dataFalse();
        }

        boolean b = studentService.delete(student);

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
