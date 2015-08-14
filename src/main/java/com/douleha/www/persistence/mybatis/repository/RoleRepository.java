package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.role.IRoleRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Repository("roleRepository")
public class RoleRepository<Role, Integer> implements IRoleRepository<Role,Integer> {

    @Override
    public Role findById(Integer integer) {
        return null;
    }

    @Override
    public int save(Role entity) {
        return 0;
    }

    @Override
    public int update(Role entity) {
        return 0;
    }

    @Override
    public int delete(Role entity) {
        return 0;
    }
}
