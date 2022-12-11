package com.globalblue.common.rest.mock;

import com.globalblue.common.core.exception.BadRequestException;

import java.util.function.Function;

public class FunctionSpy implements Function<TestRequest, TestResponse> {

    public boolean isApplyCalled;
    public boolean isUnexpectedErrorOccurred;
    public boolean isCoreExceptionOccurred;

    @Override
    public TestResponse apply(TestRequest testRequest) {
        isApplyCalled = true;
        if (isCoreExceptionOccurred) {
            throw new BadRequestException("INVALID_VALUE");
        }

        if (isUnexpectedErrorOccurred) {
            throw new RuntimeException();
        }
        return new TestResponse();
    }
}
