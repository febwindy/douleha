package com.douleha.www.persistence.mybatis.repository.general;

import com.douleha.www.persistence.mybatis.mapper.IMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
public abstract class AbstractRepository<T, ID> implements IRepository<T, ID> {

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<T> findAll() {
        return this.getMapper().findAll();
    }

    @Override
    public T findById(ID id) {
        return (T) this.getMapper().findById(id);
    }

    @Override
    public int save(T entity) {
        return this.getMapper().save(entity);
    }

    @Override
    public int update(T entity) {
        return this.getMapper().update(entity);
    }

    @Override
    public int delete(T entity) {
        return this.getMapper().delete(entity);
    }

    /**
     * 通过sqlSessionTemplate得到相应的Mapper,如果没有相应的mapper方法,请强转成相应的mapper
     * @return
     */
    protected abstract IMapper getMapper();

}
