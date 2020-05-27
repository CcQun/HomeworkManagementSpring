package org.example.javaee.class01.service;

import org.example.javaee.class01.dao.StudentDao;
import org.example.javaee.class01.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/5/26 15:38
 */
@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public List<Student> getStudentById(Long id) throws Exception{
        return studentDao.selectById(id);
    }

    public boolean addStudent(Student student) throws Exception{
        return studentDao.insert(student);
    }
}
