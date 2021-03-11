package com.smart.service;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.pojo.Student;

import java.util.List;

public interface StudentService extends IService<Student> {

    Student getOne(Integer id);
}
