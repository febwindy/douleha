package com.douleha.www.utils.type.api;

/**
 * Created by ivan_ on 2015/8/27.
 */
public class ApiResponse {

    private ApiReturnCode code;

    private String message;

    private Object data;

    public ApiResponse() {
    }

    public ApiResponse(ApiReturnCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(ApiReturnCode code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiReturnCode getCode() {
        return code;
    }

    public void setCode(ApiReturnCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
