package com.douleha.www.controller.api.v1;

import com.douleha.www.application.auth.IAuthAppService;
import com.douleha.www.application.auth.command.LoginCommand;
import com.douleha.www.controller.exception.InvalidRequestException;
import com.douleha.www.controller.shared.BaseApiController;
import com.douleha.www.utils.type.api.ApiResponse;
import com.douleha.www.utils.type.api.ApiReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ivan_ on 2015/8/27.
 */
@Controller
@RequestMapping("/v1/auth")
public class AuthorizedController extends BaseApiController {

    @Autowired
    private IAuthAppService authAppService;

    @RequestMapping("/login")
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

}
