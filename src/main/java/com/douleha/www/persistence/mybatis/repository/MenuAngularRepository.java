package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.menuangular.IMenuAngularRepository;
import com.douleha.www.domain.model.menuangular.MenuAngular;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IMenuAngularMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/28.
 */
@Repository("menuAngularRepository")
public class MenuAngularRepository extends AbstractRepository<MenuAngular, Integer> implements IMenuAngularRepository<MenuAngular, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMenuAngularMapper getMapper() {
        return sqlSessionTemplate.getMapper(IMenuAngularMapper.class);
    }

}
