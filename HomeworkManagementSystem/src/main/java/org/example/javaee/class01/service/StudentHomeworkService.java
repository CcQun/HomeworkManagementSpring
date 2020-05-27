package org.example.javaee.class01.service;

import org.example.javaee.class01.dao.StudentHomeworkDao;
import org.example.javaee.class01.model.Student;
import org.example.javaee.class01.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/5/26 16:11
 */
@Service
public class StudentHomeworkService {
    @Autowired
    StudentHomeworkDao studentHomeworkDao;

    public List<StudentHomework> selectSpecificHomework(Long homeworkId) throws Exception{
        return studentHomeworkDao.selectByHWId(homeworkId);
    }

    public boolean insertStudentHomework(StudentHomework studentHomework) throws Exception{
        return studentHomeworkDao.insert(studentHomework);
    }
}
