package com.globalblue.common.rest.exception;

public abstract class OutOfCoreException extends RuntimeException {

    public final String code;

    protected OutOfCoreException(String code, Throwable e) {
        super(e);
        this.code = code;
    }

    protected OutOfCoreException(String code) {
        this.code = code;
    }
}
