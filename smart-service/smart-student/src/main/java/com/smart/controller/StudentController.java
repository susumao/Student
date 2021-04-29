package com.smart.controller;


import com.smart.pojo.Day;
import com.smart.pojo.Student;
import com.smart.service.StudentService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
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

    public static void main(String[] args) {
        boolean validEnum = EnumUtils.isValidEnum(Day.class, "MONDAY");
        System.out.println(validEnum);
    }
}
