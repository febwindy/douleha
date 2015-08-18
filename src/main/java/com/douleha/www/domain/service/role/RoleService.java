package com.douleha.www.domain.service.role;

import com.douleha.www.domain.model.role.IRoleRepository;
import com.douleha.www.domain.model.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Service("roleService")
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
