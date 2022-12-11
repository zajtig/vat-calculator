package com.globalblue.common.rest.service;

import com.globalblue.common.rest.exception.BoundaryInException;

import java.util.function.Supplier;

public abstract class BaseService {

    protected <T> T map(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            throw new BoundaryInException(e);
        } catch (Exception e) {
            throw new BoundaryInException(e);
        }
    }
}
