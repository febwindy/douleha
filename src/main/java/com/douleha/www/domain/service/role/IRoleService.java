package com.douleha.www.domain.service.role;

import com.douleha.www.application.admin.role.command.AdminRoleCommand;
import com.douleha.www.application.admin.role.command.AdminRolePaginationCommand;
import com.douleha.www.domain.model.role.Role;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
public interface IRoleService {

    void add(AdminRoleCommand command);

    void delete(Integer id);

    void update(AdminRoleCommand command);

    Role findById(Integer id);

    List<Role> pagination(AdminRolePaginationCommand command);

    List<Role> findAll();

}
