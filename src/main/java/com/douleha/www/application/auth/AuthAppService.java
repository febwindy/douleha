package com.douleha.www.application.auth;

import com.douleha.www.application.auth.command.LoginCommand;
import com.douleha.www.controller.exception.InvalidRequestException;
import com.douleha.www.controller.exception.UnauthorizedException;
import com.douleha.www.utils.type.api.ApiResponse;
import com.douleha.www.utils.type.api.ApiReturnCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivan_ on 2015/8/27.
 */
@Service("authAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AuthAppService implements IAuthAppService {

    @Override
    public ApiResponse login(LoginCommand command) {

        if (null == command.getUsername() || StringUtils.isEmpty(command.getUsername())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_10000, ApiReturnCode.ERROR_10000.getName()));
        }

        if (null == command.getPassword() || StringUtils.isEmpty(command.getPassword())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_10001, ApiReturnCode.ERROR_10001.getName()));
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), command.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            throw new UnauthorizedException(new ApiResponse(ApiReturnCode.ERROR_10002, ApiReturnCode.ERROR_10002.getName()));
        }

        return new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName());
    }
}
