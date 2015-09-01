package com.douleha.www.application.admin.role;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/9/1.
 */
public interface IAdminRoleAppService {

    ApiResponse add();

    ApiResponse delete(Integer id);

    ApiResponse update();

    ApiResponse select(Integer id);

    ApiResponse selects();

}
