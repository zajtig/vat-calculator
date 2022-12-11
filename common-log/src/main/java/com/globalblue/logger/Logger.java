package com.globalblue.logger;

public interface Logger {

    void info(Object dataStructure);

    void error(Object dataStructure);

    void error(Object dataStructure, Throwable throwable);

    void addCustomField(String key, String value);
}
