package com.nhsoft.ledemo.service.impl;

import com.nhsoft.ledemo.dao.outdao.StudentDao;
import com.nhsoft.ledemo.dao.outdao.StudentDisciplineDao;
import com.nhsoft.ledemo.dto.DisciplineGradeDTO;
import com.nhsoft.ledemo.dto.StudentDTO;
import com.nhsoft.ledemo.dto.Uid.StudentDisciplineMpUidDTO;
import com.nhsoft.ledemo.model.Student;
import com.nhsoft.ledemo.service.StudentService;
import com.nhsoft.ledemo.util.RedisKeyConstant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 14:54
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Resource
    private StudentDisciplineDao sdRepo;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> set;


    @Override
    public boolean saveOrUpdate(Student student) {
        try {
            //判断是更改操作还是保存操作
            //保存操作需要判断编号是否唯一
            if (student.getStuId() == null) {
                //判断学生编号是否存在
                if (set.isMember(RedisKeyConstant.STUDENT_SET, student.getStuNum())) {

                    return false;
                }
            }

            Student save = studentDao.save(student);

            //判断插入成功后将学生编号存入redis中
            if (save != null) {

                set.add(RedisKeyConstant.STUDENT_SET, student.getStuNum());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean delete(StudentDTO student) {

        boolean b = true;
        try {
            studentDao.deleteById(student.getStuId());
        } catch (Exception e) {
            b = false;
        } finally{
            return b;
        }
    }

    @Override
    public Student read(StudentDTO student) {

        Specification<Student> stuId = (Specification<Student>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("stuId"), student.getStuId());
        return studentDao.findOne(stuId).get();
    }

    @Override
    public Page list(StudentDTO student) {


        PageRequest re = PageRequest.of(student.getPage(), student.getSize());

        return studentDao.findAll(re);

    }

    @Override
    public List<DisciplineGradeDTO> listDisciplineGradeDTO(StudentDisciplineMpUidDTO sd){

        List<DisciplineGradeDTO> disciplineGradeDTOS = sdRepo.listDisciplineGradeDTO(sd.getStuIdMp(),
                sd.getYears());
        return disciplineGradeDTOS;
    }
}
