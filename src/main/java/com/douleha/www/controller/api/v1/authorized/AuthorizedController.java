package com.douleha.www.controller.api.v1.authorized;

import com.douleha.www.application.auth.IAuthAppService;
import com.douleha.www.application.auth.command.LoginCommand;
import com.douleha.www.controller.exception.InvalidRequestException;
import com.douleha.www.controller.exception.UnauthorizedException;
import com.douleha.www.controller.shared.BaseApiController;
import com.douleha.www.utils.type.api.ApiResponse;
import com.douleha.www.utils.type.api.ApiReturnCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ivan_ on 2015/8/27.
 * 用户授权api接口
 */
@Controller
@RequestMapping("/v1/auth")
public class AuthorizedController extends BaseApiController {

    @Autowired
    private IAuthAppService authAppService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse login(LoginCommand command) throws Exception {

        ApiResponse apiResponse;

        if (null != command) {
            apiResponse = authAppService.login(command);
        } else {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_UNKNOWN, ApiReturnCode.ERROR_UNKNOWN.getName()));
        }

        convertToReadableForApiResponse(apiResponse);

        return apiResponse;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse logout() throws  Exception {

        ApiResponse apiResponse;

        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            apiResponse = new ApiResponse(ApiReturnCode.ERROR_10004, ApiReturnCode.ERROR_10004.getName());
        } else {
            throw new UnauthorizedException(new ApiResponse(ApiReturnCode.ERROR_10003, ApiReturnCode.ERROR_10003.getName()));
        }

        convertToReadableForApiResponse(apiResponse);

        return apiResponse;
    }

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse unauthorized() throws Exception {
        throw new UnauthorizedException(new ApiResponse(ApiReturnCode.ERROR_10003, ApiReturnCode.ERROR_10003.getName()));
    }

}
