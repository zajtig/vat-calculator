package com.globalblue.vatcalculator;

import org.springframework.http.HttpStatus;

public class DomainHelper {

    private static final DomainHelper INSTANCE = new DomainHelper();
    private ResponseWrapper actualResponse;

    public static DomainHelper getInstance() {
        return INSTANCE;
    }

    public HttpStatus getHttpStatus() {
        return actualResponse.getHttpStatus();
    }

    public String getErrorCode() {
        return actualResponse.getErrorCode();
    }

    public void setActualResponse(ResponseWrapper actualResponse) {
        this.actualResponse = actualResponse;
    }

    public <T> T getResponseAs(Class<T> tClass) {
        return tClass.cast(actualResponse.getResponseAs(tClass));
    }
}
