package com.globalblue.common.core;

import com.globalblue.common.core.exception.CoreException;

public interface Presenter {

    void deliverError(CoreException coreException);
}
