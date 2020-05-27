package org.example.javaee.class01.dao;

import org.example.javaee.class01.model.Homework;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/5/25 13:08
 */
public interface HomeworkDao {
    public List<Homework> selectAll() throws Exception;

    public boolean insert(Homework homework) throws Exception;
}
