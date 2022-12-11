package com.globalblue.common.core.exception;

import static com.globalblue.common.core.exception.ErrorType.BAD_REQUEST;

public class BadRequestException extends CoreException {

    public BadRequestException(String code) {
        super(code, BAD_REQUEST);
    }
}
