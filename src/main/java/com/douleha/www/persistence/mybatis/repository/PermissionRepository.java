package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.permission.IPermissionRepository;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IPermissionMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Repository("permissionRepository")
public class PermissionRepository<Authority, Integer> extends AbstractRepository<Authority, Integer> implements IPermissionRepository<Authority, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMapper getMapper() {
        return sqlSessionTemplate.getMapper(IPermissionMapper.class);
    }

}
