package com.globalblue.common.rest.configuration;

import com.globalblue.common.rest.exception.BoundaryInException;
import com.globalblue.common.rest.exception.BoundaryOutException;
import com.globalblue.common.rest.exception.PresenterException;
import com.globalblue.common.rest.view.ErrorDto;
import com.globalblue.logger.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

public class BaseSpringExceptionHandler {

    private static final String PATH_NOT_FOUND = "PATH_NOT_FOUND";
    private static final String MISSING_REQUEST_HEADER = "MISSING_REQUEST_HEADER";
    private static final String BODY_PROBLEM = "BODY_PROBLEM";
    private static final String SOMETHING_WENT_WRONG = "SOMETHING_WENT_WRONG";

    private final Logger logger;

    public BaseSpringExceptionHandler(Logger logger) {
        this.logger = logger;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleNotExistedApiException() {
        return createAndLogErrorDto(PATH_NOT_FOUND);
    }

    @ExceptionHandler({MissingRequestHeaderException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto catchMissingRequestHeaderException(Exception exception) {
        return createAndLogErrorDto(MISSING_REQUEST_HEADER, exception);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto catchUnreadableRequestBodyException(Exception exception) {
        return createAndLogErrorDto(BODY_PROBLEM, exception);
    }

    @ExceptionHandler(PresenterException.class)
    public ResponseEntity<ErrorDto> handleOutOfCoreException(PresenterException exception) {
        return new ResponseEntity<>(createAndLogErrorDto(exception.code, exception), exception.httpStatus);
    }

    @ExceptionHandler(BoundaryInException.class)
    public ResponseEntity<ErrorDto> handleBoundaryInException(BoundaryInException exception) {
        return new ResponseEntity<>(createAndLogErrorDto(exception.code, exception), exception.httpStatus);
    }

    @ExceptionHandler(BoundaryOutException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleBoundaryOutException(BoundaryOutException exception) {
        return createAndLogErrorDto(exception.code, exception);
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleUnexpectedException(Throwable exception) {
        return createAndLogErrorDto(SOMETHING_WENT_WRONG, exception);
    }

    private ErrorDto createAndLogErrorDto(String errorCode, Throwable exception) {
        var result = new ErrorDto(errorCode);
        logger.error(result, exception);
        return result;
    }

    private ErrorDto createAndLogErrorDto(String errorCode) {
        return createAndLogErrorDto(errorCode, null);
    }
}