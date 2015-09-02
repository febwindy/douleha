package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.url.IUrlRepository;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IUrlMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/28.
 */
@Repository("urlRepository")
public class UrlRepository<Url, Integer> extends AbstractRepository<Url, Integer> implements IUrlRepository<Url,Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IUrlMapper getMapper() {
        return sqlSessionTemplate.getMapper(IUrlMapper.class);
    }

}
