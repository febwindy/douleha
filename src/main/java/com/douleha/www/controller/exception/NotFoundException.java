package com.douleha.www.controller.exception;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 * [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。 httpStatus 404
 */
public class NotFoundException extends RuntimeException {

    private ApiResponse apiResponse;

    public NotFoundException() {
        super();
    }

    public NotFoundException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
