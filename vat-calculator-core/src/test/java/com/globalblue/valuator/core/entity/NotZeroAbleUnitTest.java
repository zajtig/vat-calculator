package com.globalblue.valuator.core.entity;

import com.globalblue.vatcalculator.core.entity.NotZeroAble;
import org.junit.jupiter.api.Test;

import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NotZeroAbleUnitTest {

    @Test
    void zeroNotAllowedTest() {
        TestNotZeroAble notZeroAble = new TestNotZeroAble();
        assertThrows(IllegalArgumentException.class, () -> notZeroAble.chekZero(ZERO, "NOT_ALLOWED"));
    }

    private static class TestNotZeroAble implements NotZeroAble {

    }
}