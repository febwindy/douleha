package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.menu.IMenuRepository;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IMenuMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Repository("menuRepository")
public class MenuRepository<Menu, Integer> extends AbstractRepository<Menu, Integer> implements IMenuRepository<Menu, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMapper getMapper() {
        return sqlSessionTemplate.getMapper(IMenuMapper.class);
    }
}
