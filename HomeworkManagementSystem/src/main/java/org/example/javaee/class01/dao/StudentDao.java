package org.example.javaee.class01.dao;

import org.example.javaee.class01.model.Student;

import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/5/26 15:24
 */
public interface StudentDao {
    public boolean insert(Student student) throws Exception;

    public List<Student> selectById(Long id) throws Exception;
}
