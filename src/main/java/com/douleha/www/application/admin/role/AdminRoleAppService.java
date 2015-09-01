package com.douleha.www.application.admin.role;

import com.douleha.www.domain.service.role.IRoleService;
import com.douleha.www.utils.type.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivan_ on 2015/9/1.
 */
@Service("adminRoleAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AdminRoleAppService implements IAdminRoleAppService {

    @Autowired
    private IRoleService roleService;

    @Override
    public ApiResponse add() {
        return null;
    }

    @Override
    public ApiResponse delete(Integer id) {
        return null;
    }

    @Override
    public ApiResponse update() {
        return null;
    }

    @Override
    public ApiResponse select(Integer id) {
        return null;
    }

    @Override
    public ApiResponse selects() {
        return null;
    }
}
