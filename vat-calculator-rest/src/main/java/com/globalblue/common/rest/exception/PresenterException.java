package com.globalblue.common.rest.exception;

import org.springframework.http.HttpStatus;

public class PresenterException extends OutOfCoreException {

    public final HttpStatus httpStatus;

    public PresenterException(HttpStatus httpStatus, String code) {
        super(code);
        this.httpStatus = httpStatus;
    }
}
