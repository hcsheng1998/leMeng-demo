package com.nhsoft.ledemo.controller;

import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.dto.ResponseMessageDTO;
import com.nhsoft.ledemo.dto.StudentDTO;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Student;
import com.nhsoft.ledemo.model.uid.StudentDisciplineMpUid;
import com.nhsoft.ledemo.service.StudentDisciplineMappingService;
import com.nhsoft.ledemo.service.StudentService;
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
@Api(tags = "学生信息模块")
@RestController
@RequestMapping("/student/")
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentDisciplineMappingService studentDisciplineMappingService;

    @ApiOperation("学生查询本人每学年各学科成绩接口")
    @GetMapping("listSubjectGrade")
    public ResponseMessageDTO listSubjectGrade(@ApiParam("封装参数:years和stuIdMp") StudentDisciplineMpUidDTO studentDisciplineMpUidDTO) {

        log.info("接口的参数:" + studentDisciplineMpUidDTO);
        ResponseMessageDTO responseMessageDTO = null;

        List<DisciplineGradeDTO> disciplineGradeDTOList = studentDisciplineMappingService.listDisciplineGrade(CopyUtil.to(studentDisciplineMpUidDTO, StudentDisciplineMpUid.class));

        if (disciplineGradeDTOList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(disciplineGradeDTOList);
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询所有的学生,并分页")
    @PostMapping("list")
    public ResponseMessageDTO listAll(@ApiParam("分页信息,page,size") PagingDTO pagingDTO) {

        log.info("接口的参数:" + pagingDTO);
        ResponseMessageDTO responseMessageDTO = null;

        List<Student> studentList = studentService.listAll(pagingDTO);

        if (studentList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(CopyUtil.toList(studentList, StudentDTO.class));
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("查询一个学生信息")
    @PostMapping("read")
    public ResponseMessageDTO read(@ApiParam("学生主键") Long stuId) {

        log.info("接口的参数:" + stuId);
        ResponseMessageDTO responseMessageDTO = null;

        Student student = studentService.read(stuId);

        if (student == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc(CopyUtil.to(student, StudentDTO.class));
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量保存或更新学生信息")
    @PostMapping("saveOrUpdate")
    public ResponseMessageDTO saveOrUpdate(@ApiParam("学生集合")  @RequestParam("studentDTOList") List<StudentDTO> studentDTOList) {

        log.info("接口的参数:" + studentDTOList);
        ResponseMessageDTO responseMessageDTO = null;

        List<Student> studentList = studentService.batchSaveOrUpdate(CopyUtil.toList(studentDTOList, Student.class));

        if (studentList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }

    @ApiOperation("批量删除学生信息")
    @PostMapping("delete")
    public ResponseMessageDTO delete(@ApiParam("学生主键集合") @RequestParam("stuIdList") List<Long> stuIdList) {

        log.info("接口的参数:" + stuIdList);
        ResponseMessageDTO responseMessageDTO = null;

        stuIdList = studentService.batchDelete(stuIdList);

        if (stuIdList == null) {
            responseMessageDTO = ResponseUtil.opeFail();
        } else {
            responseMessageDTO = ResponseUtil.opeSuc();
        }

        log.info("接口的返回值是" + responseMessageDTO);
        return responseMessageDTO;
    }
}
