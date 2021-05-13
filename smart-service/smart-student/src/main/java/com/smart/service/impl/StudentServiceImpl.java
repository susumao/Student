package com.smart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.dao.StudentDao;
import com.smart.pojo.Student;
import com.smart.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl extends ServiceImpl<StudentDao,Student> implements StudentService {
    private final StudentDao studentDao;

    @Override
    public Student getOne(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }

}
