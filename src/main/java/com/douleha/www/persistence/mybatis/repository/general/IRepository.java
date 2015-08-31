package com.douleha.www.persistence.mybatis.repository.general;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IRepository<T, ID> {

    int add(T entity);

    int delete(ID id);

    int update(T entity);

    List<T> findAll();

    T findById(ID id);

}
