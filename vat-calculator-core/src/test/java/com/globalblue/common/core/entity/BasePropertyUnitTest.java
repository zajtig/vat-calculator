package com.globalblue.common.core.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BasePropertyUnitTest {

    @Test
    void createByStringNotMandatoryTest() {
        var baseProperty = new TestBaseProperty("NAME",
                false, "20");
        assertTrue(baseProperty.isConvertCalled);
        assertEquals(new BigDecimal("20"), baseProperty.value);
        assertTrue(baseProperty.isPresent());
    }

    @Test
    void createByBigDecimalNotMandatoryTest() {
        var baseProperty = new TestBaseProperty("NAME",
                false, (BigDecimal) null);
        assertFalse(baseProperty.isConvertCalled);
        assertFalse(baseProperty.isPresent());
    }

    @Test
    void mandatoryForBigDecimalTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new TestBaseProperty("NAME",
                        true, (BigDecimal) null));
    }

    @Test
    void mandatoryForStringTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new TestBaseProperty("NAME",
                        true, (String) null));
    }

    private static class TestBaseProperty extends BaseProperty<BigDecimal> {

        public boolean isConvertCalled;

        public TestBaseProperty(String name, boolean isMandatory, String value) {
            super(name, isMandatory, value);
        }

        public TestBaseProperty(String name, boolean isMandatory, BigDecimal value) {
            super(name, isMandatory, value);
        }

        @Override
        protected BigDecimal convert(String value) {
            isConvertCalled = true;
            return new BigDecimal(value);
        }
    }
}
