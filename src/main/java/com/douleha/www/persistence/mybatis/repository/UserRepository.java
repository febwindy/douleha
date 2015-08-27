package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.user.IUserRepository;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IUserMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/13.
 */
@Repository("userRepository")
public class UserRepository<User, Integer> extends AbstractRepository<User, Integer> implements IUserRepository<User, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMapper getMapper() {
        return sqlSessionTemplate.getMapper(IUserMapper.class);
    }

    @Override
    public User findByUsername(String username) {
        return (User) ((IUserMapper)getMapper()).findByUsername(username);
    }

}
