package com.globalblue.vatcalculator;

import com.globalblue.common.rest.view.ErrorDto;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;

public class ResponseWrapper {

    private final Response response;

    public HttpStatus getHttpStatus() {
        return HttpStatus.valueOf(response.getStatusCode());
    }

    public String getErrorCode() {
        return getResponseAs(ErrorDto.class).error;
    }

    public ResponseWrapper(Response response) {
        this.response = response;
    }

    public <T> T getResponseAs(Class<T> tClass) {
        try {
            return response.then().extract().as(tClass);
        } catch (Exception e) {
            throw new RuntimeException(String.format("It isn't a %s", tClass));
        }
    }
}