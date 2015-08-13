package com.douleha.www.persistence.mybatis.repository.general;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IRepository<T, ID> {

    T findById(ID id);

    int save(T entity);

    int update(T entity);

    int delete(T entity);

}
