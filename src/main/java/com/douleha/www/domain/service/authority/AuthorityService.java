package com.douleha.www.domain.service.authority;

import com.douleha.www.domain.model.permission.IPermissionRepository;
import com.douleha.www.domain.model.permission.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Service("authorityService")
public class AuthorityService implements IAuthorityService {

    @Autowired
    private IPermissionRepository authorityRepository;

    @Override
    public List<Permission> findAll() {
        return authorityRepository.findAll();
    }
}
