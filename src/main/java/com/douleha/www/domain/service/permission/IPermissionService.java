package com.douleha.www.domain.service.permission;

import com.douleha.www.application.admin.permission.command.AdminPermissionCommand;
import com.douleha.www.application.admin.permission.command.AdminPermissionPaginationCommand;
import com.douleha.www.domain.model.permission.Permission;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
public interface IPermissionService {

    void add(AdminPermissionCommand command);

    void delete(Integer id);

    void update(AdminPermissionCommand command);

    Permission findById(Integer id);

    List<Permission> pagination(AdminPermissionPaginationCommand command);

    List<Permission> findAll();

}
