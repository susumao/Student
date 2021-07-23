package com.smart.controller;


import com.smart.pojo.Student;
import com.smart.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.ServerException;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;


@RestController
@AllArgsConstructor
@CrossOrigin
public class StudentController {
    private final StudentService studentService;
    private static final String URL = "http://sz.xrdev.cn/inspection/";

    @GetMapping("/query/{id}")
    public Student query(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Student student = studentService.getById(id);
        if (Objects.isNull(student)) throw new ServerException("未找到");
        return student;
    }

    @GetMapping("/insert")
    public String insert() {
        Student student = new Student();
        student.setAddr("深圳");
        student.setAge(11);
        student.setBirthday(new Date());
        student.setName("艾欧里亚");
        studentService.insert(student);
        return "新增成功!";
    }

    @GetMapping("/update")
    public Boolean update(Model model) {
        Student student = new Student();
        student.setId(5);
        student.setAge(66);
        return studentService.updateById(student);
    }

    @GetMapping("/delete/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return studentService.removeById(id);
    }

    public static void getSampleCodeList(String customKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HashMap<Object, Object> textParams = new HashMap<>();
        textParams.put("customKey", customKey);
        HttpEntity<Object> entity = new HttpEntity<Object>(textParams, headers);
        headers.add("Content-Type", "application/json");
        String s = restTemplate.postForObject(URL, entity, String.class);
    }

}


