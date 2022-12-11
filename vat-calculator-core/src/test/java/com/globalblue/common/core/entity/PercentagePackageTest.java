package com.globalblue.common.core.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PercentagePackageTest {

    @Test
    void createByStringTest() {
        TestPercentage decimalNumberProperty = new TestPercentage("NAME",
                true, "20");
        assertEquals(decimalNumberProperty.value, new BigDecimal("0.20"));
    }

    private static class TestPercentage extends Percentage {

        public TestPercentage(String name, Boolean isMandatory, String value) {
            super(name, isMandatory, value);
        }
    }

}
