package com.globalblue.common.rest.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorDtoUnitTest {

    @Test
    void createTest() {
        var errorDto = new ErrorDto("INVALID");
        assertEquals("INVALID", errorDto.error);
        assertDoesNotThrow((ThrowingSupplier<ErrorDto>) ErrorDto::new);
    }
}