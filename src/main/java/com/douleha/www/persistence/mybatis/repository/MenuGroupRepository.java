package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.menugroup.IMenuGroupRepository;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IMenuGroupMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/28.
 */
@Repository("menuGroupRepository")
public class MenuGroupRepository<MenuGroup, Integer> extends AbstractRepository<MenuGroup, Integer> implements IMenuGroupRepository<MenuGroup, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMenuGroupMapper getMapper() {
        return sqlSessionTemplate.getMapper(IMenuGroupMapper.class);
    }

}
