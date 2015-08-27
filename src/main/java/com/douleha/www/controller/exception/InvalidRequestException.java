package com.douleha.www.controller.exception;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 * [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。 httpStatus 400
 */
public class InvalidRequestException extends RuntimeException {

    private ApiResponse apiResponse;

    public InvalidRequestException() {
        super();
    }

    public InvalidRequestException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestException(Throwable cause) {
        super(cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
