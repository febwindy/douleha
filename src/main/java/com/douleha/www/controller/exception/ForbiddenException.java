package com.douleha.www.controller.exception;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 * [*]：表示用户得到授权（与401错误相对），但是访问是被禁止的。 httpStatus 403
 */
public class ForbiddenException extends RuntimeException {

    private ApiResponse apiResponse;

    public ForbiddenException() {
        super();
    }

    public ForbiddenException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenException(Throwable cause) {
        super(cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
