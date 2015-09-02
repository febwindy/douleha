package com.douleha.www.utils.type.api;

/**
 * Created by ivan_ on 2015/8/27.
 */
public enum ApiReturnCode {

    // 通用错误码
    ERROR_UNKNOWN(0, "ApiReturnCode.ERROR_UNKNOWN"),
    SUCCESS(1, "ApiReturnCode.SUCCESS"),
    ERROR(2, "ApiReturnCode.ERROR"),
    ERROR_404(404, "ApiReturnCode.ERROR_404"),
    ERROR_405(405, "ApiReturnCode.ERROR_405"),
    ERROR_500(500, "ApiReturnCode.ERROR_500"),

    // auth
    ERROR_10000(10000, "ApiReturnCode.ERROR_10000"),
    ERROR_10001(10001, "ApiReturnCode.ERROR_10001"),
    ERROR_10002(10002, "ApiReturnCode.ERROR_10002"),
    ERROR_10003(10003, "ApiReturnCode.ERROR_10003"),
    ERROR_10004(10004, "ApiReturnCode.ERROR_10004"),
    ERROR_10005(10005, "ApiReturnCode.ERROR_10005"),

    // adminUser
    ERROR_20000(20000, "ApiReturnCode.ERROR_20000"),
    ERROR_20001(20001, "ApiReturnCode.ERROR_20001"),
    ERROR_20002(20002, "ApiReturnCode.ERROR_20002"),
    ERROR_20003(20003, "ApiReturnCode.ERROR_20003"),

    // adminRole
    ERROR_30000(30000, "ApiReturnCode.ERROR_30000"),
    ERROR_30001(30001, "ApiReturnCode.ERROR_30001"),
    ERROR_30002(30002, "ApiReturnCode.ERROR_30002");

    ApiReturnCode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
