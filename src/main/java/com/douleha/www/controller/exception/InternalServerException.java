package com.douleha.www.controller.exception;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 * [*]：服务器发生错误，用户将无法判断发出的请求是否成功。 httpStatus 500
 */
public class InternalServerException extends RuntimeException {

    private ApiResponse apiResponse;

    public InternalServerException() {
        super();
    }

    public InternalServerException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerException(Throwable cause) {
        super(cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
