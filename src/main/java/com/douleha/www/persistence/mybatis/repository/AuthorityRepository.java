package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.authority.IAuthorityRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Repository("authorityRepository")
public class AuthorityRepository<Authority, Integer> implements IAuthorityRepository<Authority, Integer> {

    @Override
    public Authority findById(Integer integer) {
        return null;
    }

    @Override
    public int save(Authority entity) {
        return 0;
    }

    @Override
    public int update(Authority entity) {
        return 0;
    }

    @Override
    public int delete(Authority entity) {
        return 0;
    }
}
