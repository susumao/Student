package com.smart.service.impl;

import com.smart.entity.Student;
import com.smart.mapper.StudentMapper;
import com.smart.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author maol
 * @since 2021-03-11
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
