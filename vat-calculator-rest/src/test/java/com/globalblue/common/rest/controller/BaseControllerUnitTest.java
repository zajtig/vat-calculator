package com.globalblue.common.rest.controller;

import com.globalblue.common.rest.mock.FunctionSpy;
import com.globalblue.common.rest.mock.TestRequest;
import com.globalblue.common.rest.mock.TestResponse;
import com.globalblue.vatcalculator.mock.LoggerMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BaseControllerUnitTest {

    private TestBaseController controller;
    private LoggerMock loggerMock;
    private FunctionSpy mapperFunctionSpy;

    @BeforeEach
    void setUp() {
        loggerMock = new LoggerMock();
        mapperFunctionSpy = new FunctionSpy();
        controller = new TestBaseController();
    }

    @Test
    void callServiceTest() {
        String requestId = UUID.randomUUID().toString();
        controller.callService(mapperFunctionSpy, new TestRequest(), requestId);
        assertTrue(mapperFunctionSpy.isApplyCalled);
        assertEquals("REQUEST: [requestData=requestData]", loggerMock.loggedInformationList.get(0));
        assertEquals("RESPONSE: [responseData=responseData]", loggerMock.loggedInformationList.get(1));
        assertNotNull(loggerMock.requestIdCustomField.getRight());
        assertEquals(requestId, loggerMock.requestIdCustomField.getRight());
        assertEquals("x-request-id", loggerMock.requestIdCustomField.getLeft());
    }

    private class TestBaseController extends BaseController<TestRequest, TestResponse> {

        public TestBaseController() {
            super(loggerMock);
        }
    }
}
