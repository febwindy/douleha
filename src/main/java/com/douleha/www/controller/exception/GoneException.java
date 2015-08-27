package com.douleha.www.controller.exception;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 * [GET]：用户请求的资源被永久删除，且不会再得到的。 httpStatus 410
 */
public class GoneException extends RuntimeException {

    private ApiResponse apiResponse;

    public GoneException() {
        super();
    }

    public GoneException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public GoneException(String message) {
        super(message);
    }

    public GoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoneException(Throwable cause) {
        super(cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
