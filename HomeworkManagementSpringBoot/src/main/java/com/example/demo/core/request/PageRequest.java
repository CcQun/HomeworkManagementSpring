package com.example.demo.core.request;

import lombok.Data;

/**
 * @Author CcQun
 * @Date 2020/5/18 10:35
 */
@Data
public class PageRequest {
    private int page = 0;
    private int size = 10;
}
