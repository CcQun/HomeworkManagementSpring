package com.example.demo.core.response;

import lombok.Data;

/**
 * @Author CcQun
 * @Date 2020/5/17 10:39
 */
@Data
public abstract class BaseResponse {
    private int code;
    private String msg;
}
