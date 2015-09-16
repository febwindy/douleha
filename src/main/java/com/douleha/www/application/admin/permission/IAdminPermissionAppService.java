package com.douleha.www.application.admin.permission;

import com.douleha.www.application.admin.permission.command.AdminPermissionCommand;
import com.douleha.www.application.admin.permission.command.AdminPermissionPaginationCommand;
import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/9/9.
 */
public interface IAdminPermissionAppService {

    ApiResponse add(AdminPermissionCommand command);

    ApiResponse delete(Integer id);

    ApiResponse update(AdminPermissionCommand command);

    ApiResponse select(Integer id);

    ApiResponse selects(AdminPermissionPaginationCommand command);

}
