package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.authority.IAuthorityRepository;
import com.douleha.www.persistence.mybatis.mapper.IAuthorityMapper;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Repository("authorityRepository")
public class AuthorityRepository<Authority, Integer> extends AbstractRepository<Authority, Integer> implements IAuthorityRepository<Authority, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMapper getMapper() {
        return sqlSessionTemplate.getMapper(IAuthorityMapper.class);
    }

}