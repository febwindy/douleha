package com.douleha.www.application.auth;

import com.douleha.www.application.auth.command.LoginCommand;
import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 */
public interface IAuthAppService {

    ApiResponse login(LoginCommand command);

}
