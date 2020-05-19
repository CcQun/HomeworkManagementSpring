package com.example.demo.db.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author CcQun
 * @Date 2020/5/19 15:22
 */
@NoRepositoryBean
public interface BaseMapper<E,PK> extends JpaRepository<E,PK>, JpaSpecificationExecutor<E> {
}
