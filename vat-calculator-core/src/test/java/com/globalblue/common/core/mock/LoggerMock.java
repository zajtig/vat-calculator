package com.globalblue.common.core.mock;

import com.globalblue.logger.Logger;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class LoggerMock implements Logger {

    public List<String> loggedInformationList = new ArrayList<>();
    public Pair<String, String> requestIdCustomField;

    @Override
    public void info(Object dataStructure) {

    }

    @Override
    public void error(Object dataStructure) {

    }

    @Override
    public void error(Object dataStructure, Throwable throwable) {
        loggedInformationList.add(dataStructure.toString());
    }

    @Override
    public void addCustomField(String key, String value) {
        requestIdCustomField = Pair.of(key, value);
    }
}
