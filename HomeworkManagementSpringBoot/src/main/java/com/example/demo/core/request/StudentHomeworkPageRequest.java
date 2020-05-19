package com.example.demo.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author CcQun
 * @Date 2020/5/18 10:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentHomeworkPageRequest extends PageRequest{
    private Long homeworkId;
}
