package com.example.demo.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author CcQun
 * @Date 2020/5/16 14:05
 * StudentHomework实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s_student_homework")
public class StudentHomework {
    @Id
    private Long id;

    private Long studentId;
    private Long homeworkId;
    private String homeworkTitle;
    private String homeworkContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date createTime;
    private Date updateTime;
}
