package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.user.IUserRepository;
import com.douleha.www.persistence.mybatis.mapper.IUserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/13.
 */
@Repository("userRepository")
public class UserRepository<User, Integer> implements IUserRepository<User, Integer> {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private IUserMapper<User, Integer> getMapper() {
        return sqlSessionTemplate.getMapper(IUserMapper.class);
    }

    @Override
    public User findById(Integer id) {
        return getMapper().findById(id);
    }

    @Override
    public int save(User entity) {
        return getMapper().save(entity);
    }

    @Override
    public int update(User entity) {
        return 0;
    }

    @Override
    public int delete(User entity) {
        return 0;
    }
}
