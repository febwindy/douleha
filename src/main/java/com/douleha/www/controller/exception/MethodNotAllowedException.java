package com.douleha.www.controller.exception;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/31.
 * [*]：用户发出的请求是一个不存在的方法时。 httpStatus 405
 */
public class MethodNotAllowedException extends RuntimeException {

    private ApiResponse apiResponse;

    public MethodNotAllowedException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public MethodNotAllowedException(String message) {
        super(message);
    }

    public MethodNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodNotAllowedException(Throwable cause) {
        super(cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
