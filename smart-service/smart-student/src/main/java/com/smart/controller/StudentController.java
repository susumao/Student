package com.smart.controller;


import com.smart.pojo.Student;
import com.smart.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/query/{id}")
    public Student query(@PathVariable Integer id) throws Exception {
        Student student = studentService.getById(id);
        if (Objects.isNull(student)) throw new Exception("未找到");
        return student;

    }
}
