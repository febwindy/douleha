package com.douleha.www.application.auth;

import com.douleha.www.application.auth.command.LoginCommand;
import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 */
public interface IAuthAppService {

    /**
     * 用户授权接口，返回类型为ApiResponse
     * command参数有两个
     *      1、username，如果用户名为空，将抛出InvalidRequestException异常，并且httpStatus为400;
     *      2、password，如果密码为空，返回结果和username一样
     * @param command
     * @return
     */
    ApiResponse login(LoginCommand command);

}
