package com.globalblue.common.rest.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class BoundaryInException extends OutOfCoreException {

    public final HttpStatus httpStatus;

    public BoundaryInException(IllegalArgumentException e) {
        super(e.getMessage(), e);
        httpStatus = BAD_REQUEST;
    }

    public BoundaryInException(Throwable e) {
        super(e.getMessage(), e);
        httpStatus = INTERNAL_SERVER_ERROR;
    }
}