package com.example.demo.db.mapper;

import com.example.demo.db.model.Homework;
import com.example.demo.db.model.StudentHomework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author CcQun
 * @Date 2020/5/16 8:27
 */
public interface HomeworkMapper extends BaseMapper<Homework,Long> {
}
