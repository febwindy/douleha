package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.menuapp.IMenuAppRepository;
import com.douleha.www.domain.model.menuapp.MenuApp;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IMenuAppMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ivan_ on 2015/8/28.
 */
public class MenuAppRepository extends AbstractRepository<MenuApp, Integer> implements IMenuAppRepository<MenuApp, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMapper getMapper() {
        return sqlSessionTemplate.getMapper(IMenuAppMapper.class);
    }

}
