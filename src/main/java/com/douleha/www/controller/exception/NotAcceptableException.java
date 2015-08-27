package com.douleha.www.controller.exception;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 * [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。 httpStatus 406
 */
public class NotAcceptableException extends RuntimeException {

    private ApiResponse apiResponse;

    public NotAcceptableException() {
        super();
    }

    public NotAcceptableException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public NotAcceptableException(String message) {
        super(message);
    }

    public NotAcceptableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAcceptableException(Throwable cause) {
        super(cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
