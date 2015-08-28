package com.douleha.www.domain.service.permission;

import com.douleha.www.domain.model.permission.IPermissionRepository;
import com.douleha.www.domain.model.permission.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Service("authorityService")
public class PermissionService implements IPermissionService {

    @Autowired
    private IPermissionRepository permissionRepository;

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
}
