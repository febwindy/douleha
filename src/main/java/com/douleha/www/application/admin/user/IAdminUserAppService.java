package com.douleha.www.application.admin.user;

import com.douleha.www.application.admin.user.command.AdminUserCommand;
import com.douleha.www.application.admin.user.command.AdminUserPaginationCommand;
import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/31.
 */
public interface IAdminUserAppService {

    ApiResponse add(AdminUserCommand command);

    ApiResponse delete(Integer id);

    ApiResponse update(AdminUserCommand command);

    ApiResponse select(Integer id);

    ApiResponse selects(AdminUserPaginationCommand command);

}
