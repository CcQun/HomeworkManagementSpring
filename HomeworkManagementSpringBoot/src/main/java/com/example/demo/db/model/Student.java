package com.example.demo.db.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author CcQun
 * @Date 2020/5/16 14:01
 * Student实体类
 */

@Data
@Entity
@Table(name = "s_student")
public class Student {
    @Id
    private Long id;
    private String name;
    private Date createTime;
    private Date updateTime;
}
