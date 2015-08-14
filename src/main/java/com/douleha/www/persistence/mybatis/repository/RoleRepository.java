package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.role.IRoleRepository;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IRoleMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Repository("roleRepository")
public class RoleRepository<Role, Integer> extends AbstractRepository<Role, Integer> implements IRoleRepository<Role,Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMapper getMapper() {
        return sqlSessionTemplate.getMapper(IRoleMapper.class);
    }
}
