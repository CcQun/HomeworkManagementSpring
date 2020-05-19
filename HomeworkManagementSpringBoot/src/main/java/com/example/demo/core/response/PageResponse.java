package com.example.demo.core.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author CcQun
 * @Date 2020/5/17 10:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageResponse<T> extends ListResponse<T> {
    private Long total;
}
