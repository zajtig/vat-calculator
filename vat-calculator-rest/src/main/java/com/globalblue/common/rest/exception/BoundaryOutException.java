package com.globalblue.common.rest.exception;

public class BoundaryOutException extends OutOfCoreException {

    public BoundaryOutException(Throwable e) {
        super("SOMETHING_WENT_WRONG", e);
    }

    public BoundaryOutException() {
        super("SOMETHING_WENT_WRONG", null);
    }
}