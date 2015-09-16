package com.douleha.www.application.admin.url;

import com.douleha.www.application.admin.url.command.AdminUrlCommand;
import com.douleha.www.application.admin.url.command.AdminUrlPaginationCommand;
import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/9/16.
 */
public interface IAdminUrlAppService {

    ApiResponse add(AdminUrlCommand command);

    ApiResponse delete(Integer id);

    ApiResponse update(AdminUrlCommand command);

    ApiResponse select(Integer id);

    ApiResponse selects(AdminUrlPaginationCommand command);

}
