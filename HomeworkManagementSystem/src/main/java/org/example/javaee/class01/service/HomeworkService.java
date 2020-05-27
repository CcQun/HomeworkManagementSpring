package org.example.javaee.class01.service;

import org.example.javaee.class01.dao.HomeworkDao;
import org.example.javaee.class01.model.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/5/25 13:42
 */
@Service
public class HomeworkService {
    @Autowired
    HomeworkDao homeworkDao;

    public List<Homework> displayHomework() throws Exception {
        return homeworkDao.selectAll();
    }

    public boolean insertHomework(Homework homework) throws Exception{
        return homeworkDao.insert(homework);
    }
}
