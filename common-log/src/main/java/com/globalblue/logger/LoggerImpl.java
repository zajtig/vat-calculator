package com.globalblue.logger;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Objects;

public class LoggerImpl implements Logger {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LoggerImpl.class);

    @Override
    public void info(Object dataStructure) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(Objects.toString(dataStructure, null));
        }
    }

    @Override
    public void error(Object dataStructure) {
        if (LOGGER.isErrorEnabled()) {
            LOGGER.error(Objects.toString(dataStructure, null));
        }
    }

    @Override
    public void error(Object dataStructure, Throwable throwable) {
        if (LOGGER.isErrorEnabled()) {
            LOGGER.error(Objects.toString(dataStructure, null), throwable);
        }
    }

    @Override
    public void addCustomField(String key, String value) {
        MDC.put(key, value);
    }
}
