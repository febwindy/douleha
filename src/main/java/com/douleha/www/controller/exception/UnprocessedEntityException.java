package com.douleha.www.controller.exception;

import com.douleha.www.utils.type.api.ApiResponse;

/**
 * Created by ivan_ on 2015/8/27.
 * [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。 httpStatus 422
 */
public class UnprocessedEntityException extends RuntimeException {

    private ApiResponse apiResponse;

    public UnprocessedEntityException() {
        super();
    }

    public UnprocessedEntityException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public UnprocessedEntityException(String message) {
        super(message);
    }

    public UnprocessedEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnprocessedEntityException(Throwable cause) {
        super(cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
