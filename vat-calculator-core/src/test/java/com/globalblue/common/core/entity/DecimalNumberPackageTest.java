package com.globalblue.common.core.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DecimalNumberPackageTest {

    @Test
    void createByStringTest() {
        TestDecimalNumber decimalNumber = new TestDecimalNumber("NAME",
                true, "20");
        assertEquals(decimalNumber.value, new BigDecimal("20"));
    }

    @Test
    void createByBigDecimalTest() {
        TestDecimalNumber decimalNumber = new TestDecimalNumber("NAME",
                true, new BigDecimal("20"));
        assertEquals(decimalNumber.value, new BigDecimal("20"));
    }

    @Test
    void conversionErrorTest() {
        assertThrows(IllegalArgumentException.class, () -> new TestDecimalNumber("NAME",
                true, "TEXT"));
    }

    private static class TestDecimalNumber extends DecimalNumber {

        public TestDecimalNumber(String name, Boolean isMandatory, String value) {
            super(name, isMandatory, value);
        }

        public TestDecimalNumber(String name, Boolean isMandatory, BigDecimal value) {
            super(name, isMandatory, value);
        }
    }
}
