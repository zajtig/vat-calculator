package com.globalblue.valuator.core.entity;

import com.globalblue.vatcalculator.core.entity.VatCalculationDecimalNumber;
import org.junit.jupiter.api.Test;

import static java.math.BigDecimal.ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VatCalculationDecimalNumberIntTest {

    @Test
    void createByBigDecimalTest() {
        assertEquals(ONE, new VatCalculationDecimalNumber("NAME", true, ONE).value);
    }

    @Test
    void createByStringTest() {
        assertEquals(ONE, new VatCalculationDecimalNumber("NAME", true, "1").value);
    }

    @Test
    void zeroNotAllowedTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new VatCalculationDecimalNumber("NAME", true, "0"));
    }
}