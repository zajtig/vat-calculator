package com.globalblue.common.rest.presenter;

import com.globalblue.common.core.Presenter;
import com.globalblue.common.core.exception.CoreException;
import com.globalblue.common.core.exception.ErrorType;
import com.globalblue.common.rest.exception.BoundaryOutException;
import com.globalblue.common.rest.exception.PresenterException;
import org.springframework.http.HttpStatus;

import java.util.function.Function;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class BasePresenter implements Presenter {

    private Object entity;
    private CoreException error;

    protected void deliverResponse(Object response) {
        this.entity = response;
    }

    @Override
    public void deliverError(CoreException coreException) {
        this.error = coreException;
    }

    protected <T> T getResponseAs(Class<T> clazz) {
        checkError();
        checkResponseExists();
        return clazz.cast(entity);
    }

    protected <T, R> R map(Function<T, R> function, T entity) {
        try {
            return function.apply(entity);
        } catch (Exception e) {
            throw new BoundaryOutException(e);
        }
    }

    private void checkResponseExists() {
        if (isNull(entity)) {
            throw new BoundaryOutException();
        }
    }

    private void checkError() {
        if (nonNull(error)) {
            throw mapError();
        }
    }

    private PresenterException mapError() {
        return new PresenterException(mapHttpStatus(error.type), error.code);
    }

    private HttpStatus mapHttpStatus(ErrorType type) {
        return type == ErrorType.BAD_REQUEST ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
    }
}