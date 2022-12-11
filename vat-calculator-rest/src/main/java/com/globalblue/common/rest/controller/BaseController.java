package com.globalblue.common.rest.controller;

import com.globalblue.logger.Logger;

import java.util.function.Function;

public abstract class BaseController<T, R> {

    private final Logger logger;

    protected BaseController(Logger logger) {
        this.logger = logger;
    }

    protected R callService(Function<T, R> supplier, T request, String requestId) {
        logger.addCustomField("x-request-id", requestId);
        logger.info(String.format("REQUEST: %s", request));
        R response = supplier.apply(request);
        logger.info(String.format("RESPONSE: %s", response));
        return response;
    }
}
