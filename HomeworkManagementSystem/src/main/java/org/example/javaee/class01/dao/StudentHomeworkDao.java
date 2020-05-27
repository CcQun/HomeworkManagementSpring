package org.example.javaee.class01.dao;

import org.example.javaee.class01.model.Student;
import org.example.javaee.class01.model.StudentHomework;

import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/5/26 16:11
 */
public interface StudentHomeworkDao {
    public List<StudentHomework> selectByHWId(Long homeworkId) throws Exception;

    public boolean insert(StudentHomework studentHomework) throws Exception;
}
