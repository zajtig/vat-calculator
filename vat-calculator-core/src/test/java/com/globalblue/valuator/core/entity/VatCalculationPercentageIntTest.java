package com.globalblue.valuator.core.entity;

import com.globalblue.vatcalculator.core.entity.VatCalculationPercentage;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VatCalculationPercentageIntTest {

    @Test
    void createByStringTest() {
        assertEquals(new BigDecimal("0.01"),
                new VatCalculationPercentage("NAME", true, "1").value);
    }

    @Test
    void zeroNotAllowedTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new VatCalculationPercentage("NAME", true, "0"));
    }
}
