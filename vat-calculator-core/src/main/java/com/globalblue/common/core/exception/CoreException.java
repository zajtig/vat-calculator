package com.globalblue.common.core.exception;

public class CoreException extends RuntimeException {

    public final String code;
    public final ErrorType type;

    public CoreException(String code, ErrorType type) {
        this.code = code;
        this.type = type;
    }
}
