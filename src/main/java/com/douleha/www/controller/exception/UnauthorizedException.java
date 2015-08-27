package com.douleha.www.controller.exception;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 * [*]：表示用户没有权限（令牌、用户名、密码错误）httpStatus 401
 */
public class UnauthorizedException extends RuntimeException {

    private ApiResponse apiResponse;

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedException(Throwable cause) {
        super(cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
