package com.douleha.www.controller.shared.web;

/**
 * Created by ivan_ on 2015/8/25.
 */
public class JsonMessage {

    private Object data;

    private JsonMessageType status;

    private Object errorMsg;

    public JsonMessage() {
        super();
    }

    public JsonMessage(JsonMessageType status, Object errorMsg) {
        this.status = status;
        this.errorMsg = errorMsg;
    }

    public JsonMessage(Object data, JsonMessageType status, Object errorMsg) {
        this();
        this.data = data;
        this.status = status;
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonMessageType getStatus() {
        return status;
    }

    public void setStatus(JsonMessageType status) {
        this.status = status;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public enum JsonMessageType {
        FAILED("失败", 0),
        SUCCESS("成功", 1);

        JsonMessageType(String name, int value) {
            this.name = name;
            this.value = value;
        }

        private String name;
        private int value;

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}
