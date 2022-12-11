package com.globalblue.common.core.mock;

import com.globalblue.common.core.Presenter;
import com.globalblue.common.core.exception.CoreException;

public class PresenterSpy implements Presenter {

    public String deliveredErrorCode;

    @Override
    public void deliverError(CoreException coreException) {
        this.deliveredErrorCode = coreException.code;
    }
}
