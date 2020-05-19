package com.example.demo.db.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author CcQun
 * @Date 2020/5/16 13:52
 * Homework实体类
 */
@Data
@Entity
@Table(name = "s_homework")
public class Homework {
    @Id
    private Long id;
    private String title;
    private String content;
    private Date createTime;
    private Date updateTime;
}
