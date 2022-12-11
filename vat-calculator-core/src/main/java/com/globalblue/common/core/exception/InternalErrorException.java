package com.globalblue.common.core.exception;

import static com.globalblue.common.core.exception.ErrorType.INTERNAL;

public class InternalErrorException extends CoreException {

    public InternalErrorException() {
        super("SOMETHING_WENT_WRONG", INTERNAL);
    }
}
