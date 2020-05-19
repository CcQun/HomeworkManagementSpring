package com.example.demo.core.response;

import lombok.Data;

import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/5/17 10:37
 */
@Data
public class ListResponse<T> extends BaseResponse{
    private List<T> data;
}
