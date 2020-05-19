package com.example.demo.db.service;

import com.example.demo.db.mapper.StudentMapper;
import com.example.demo.db.model.Student;
import org.springframework.stereotype.Service;

/**
 * @Author CcQun
 * @Date 2020/5/16 8:57
 */
@Service
public class StudentService extends BaseService<Student,Long, StudentMapper>{
}
