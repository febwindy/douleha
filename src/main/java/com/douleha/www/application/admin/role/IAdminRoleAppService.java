package com.douleha.www.application.admin.role;

import com.douleha.www.application.admin.role.command.AdminRoleCommand;
import com.douleha.www.application.admin.role.command.AdminRolePaginationCommand;
import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/9/1.
 */
public interface IAdminRoleAppService {

    ApiResponse add(AdminRoleCommand command);

    ApiResponse delete(Integer id);

    ApiResponse update(AdminRoleCommand command);

    ApiResponse select(Integer id);

    ApiResponse selects(AdminRolePaginationCommand command);

}
