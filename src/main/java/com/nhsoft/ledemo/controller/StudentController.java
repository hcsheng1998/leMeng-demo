package com.nhsoft.ledemo.controller;

import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.ResponseMessageDTO;
import com.nhsoft.ledemo.dto.StudentDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Student;
import com.nhsoft.ledemo.service.StudentDisciplineMappingService;
import com.nhsoft.ledemo.service.StudentService;
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
 * @date 2020/12/11 : 0:10
 */
@Api(tags = "学生信息模块")
@RestController
@RequestMapping("/student/")
@Slf4j
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentDisciplineMappingService sdService;

    @ApiOperation("学生查询本人每学年各学科成绩接口")
    @GetMapping("listSubjectGradeByYears")
    public ResponseMessageDTO listSubjectGradeByYears(@ApiParam("封装参数:years和stuIdMp") StudentDisciplineMpUidDTO sd) {

        log.info("接口的参数:" + sd);
        ResponseMessageDTO responseMessageDTO = null;

        List<DisciplineGradeDTO> disciplineGradeDTOS = sdService.listDisciplineGradeDTO(sd);

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

        List<Student> students = studentService.listAll(student);

        if (students == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(students);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询一个学生信息")
    @PostMapping("readStudent")
    public ResponseMessageDTO readStudent(@ApiParam("学生主键") Long stuId) {

        log.info("接口的参数:" + stuId);
        ResponseMessageDTO responseMessageDTO = null;

        Student student = studentService.readById(stuId);

        if (student == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(student);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量保存或更新学生信息")
    @PostMapping("saveOrUpdateStudent")
    public ResponseMessageDTO saveOrUpdateStudent(@ApiParam("学生集合")  @RequestParam("students") List<StudentDTO> students) {

        log.info("接口的参数:" + students);
        ResponseMessageDTO responseMessageDTO = null;

        List<StudentDTO> studentDTOS = studentService.batchSaveOrUpdate(students);

        if (studentDTOS == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量删除学生信息")
    @PostMapping("deleteStudent")
    public ResponseMessageDTO deleteStudent(@ApiParam("学生主键集合") @RequestParam("stuIds") List<Long> stuIds) {

        log.info("接口的参数:" + stuIds);
        ResponseMessageDTO responseMessageDTO = null;

        List<Long> ids = studentService.batchDelete(stuIds);

        if (ids == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }
}
