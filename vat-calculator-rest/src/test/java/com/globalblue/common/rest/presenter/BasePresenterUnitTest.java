package com.globalblue.common.rest.presenter;

import com.globalblue.common.core.exception.BadRequestException;
import com.globalblue.common.core.exception.InternalErrorException;
import com.globalblue.common.rest.exception.BoundaryOutException;
import com.globalblue.common.rest.exception.PresenterException;
import com.globalblue.common.rest.mock.FunctionSpy;
import com.globalblue.common.rest.mock.TestEntity;
import com.globalblue.common.rest.mock.TestRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

class BasePresenterUnitTest {

    private TestBasePresenter presenter;
    private FunctionSpy mapperFunctionSpy;

    @BeforeEach
    void setUp() {
        presenter = new TestBasePresenter();
        mapperFunctionSpy = new FunctionSpy();
    }

    @Test
    void deliverAndGetResponseTest() {
        presenter.deliverResponse(new TestEntity());
        assertNotNull(presenter.getResponseAs(Object.class));
    }

    @Test
    void deliverAndGetNotExistingResponseTest() {
        presenter.deliverResponse(null);
        assertThrows(BoundaryOutException.class, () -> presenter.getResponseAs(Object.class));
    }

    @Test
    void deliverCoreExceptionTest() {
        presenter.deliverError(new BadRequestException("INVALID_INPUT"));
        PresenterException presenterException = assertThrows(PresenterException.class,
                () -> presenter.getResponseAs(Object.class));
        assertEquals(BAD_REQUEST, presenterException.httpStatus);
        assertEquals("INVALID_INPUT", presenterException.code);
    }

    @Test
    void deliverUnexpectedExceptionTest() {
        presenter.deliverError(new InternalErrorException());
        PresenterException presenterException = assertThrows(PresenterException.class,
                () -> presenter.getResponseAs(Object.class));
        assertEquals(INTERNAL_SERVER_ERROR, presenterException.httpStatus);
        assertEquals("SOMETHING_WENT_WRONG", presenterException.code);
    }

    @Test
    void mapTest() {
        assertNotNull(presenter.map(mapperFunctionSpy, new TestRequest()));
        assertTrue(mapperFunctionSpy.isApplyCalled);
    }

    @Test
    void mapUnexpectedErrorOccurredTest() {
        var request = new TestRequest();
        mapperFunctionSpy.isUnexpectedErrorOccurred = true;
        assertThrows(BoundaryOutException.class,
                () -> presenter.map(mapperFunctionSpy, request));
    }

    private static class TestBasePresenter extends BasePresenter {

    }
}
