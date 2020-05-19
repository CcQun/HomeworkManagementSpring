package com.example.demo.core.response;


import lombok.Data;

/**
 * @Author CcQun
 * @Date 2020/5/16 12:44
 */
@Data
public class DataResponse<T> extends BaseResponse{
    private T data;
}
