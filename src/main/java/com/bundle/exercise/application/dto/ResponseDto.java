package com.bundle.exercise.application.dto;

public class ResponseDto {
    private Object data;
    private boolean responseStatus;
    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
