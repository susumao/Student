package com.smart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.pojo.Student;

public interface StudentService extends IService<Student> {

    Student getOne(Integer id);
}
