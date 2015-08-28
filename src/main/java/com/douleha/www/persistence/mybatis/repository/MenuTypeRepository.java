package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.menutype.IMenuTypeRepository;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IMenuTypeMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Repository("menuTypeRepository")
public class MenuTypeRepository<MenuType, Integer> extends AbstractRepository<MenuType, Integer> implements IMenuTypeRepository<MenuType, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMapper getMapper() {
        return sqlSessionTemplate.getMapper(IMenuTypeMapper.class);
    }
}
