package com.globalblue.vatcalculator.rest.configuration;

import com.globalblue.common.rest.configuration.BaseSpringExceptionHandler;
import com.globalblue.logger.Logger;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VatCalculatorSpringExceptionHandler extends BaseSpringExceptionHandler {

    public VatCalculatorSpringExceptionHandler(Logger logger) {
        super(logger);
    }
}
