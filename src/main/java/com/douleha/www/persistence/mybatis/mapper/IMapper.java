package com.douleha.www.persistence.mybatis.mapper;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IMapper<T, ID> {

    List<T> findAll();

    T findById(ID id);

    int save(T entity);

    int update(T entity);

    int delete(T entity);

}
