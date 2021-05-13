package com.smart.controller;


import com.smart.pojo.Student;
import com.smart.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.Date;
import java.util.Objects;


@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/query/{id}")
    public Student query(@PathVariable Integer id) throws Exception {
        Student student = studentService.getById(id);
        if (Objects.isNull(student)) throw new ServerException("未找到");
        return student;
    }

    @GetMapping("/insert")
    public String insert(){
        Student student = new Student();
        student.setAddr("深圳");
        student.setAge(11);
        student.setBirthday(new Date());
        student.setName("艾欧里亚");
        studentService.insert(student);
        return "新增成功!";
    }

    @GetMapping("/update")
    public Boolean update(){
        Student student = new Student();
        student.setId(5);
        student.setAge(66);
        return studentService.updateById(student);
    }

    @GetMapping("/delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        return studentService.removeById(id);
    }

}
