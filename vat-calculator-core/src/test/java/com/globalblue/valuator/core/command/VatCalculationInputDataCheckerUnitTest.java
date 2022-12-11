package com.globalblue.valuator.core.command;

import com.globalblue.common.core.exception.BadRequestException;
import com.globalblue.vatcalculator.core.command.VatCalculationInputDataChecker;
import com.globalblue.vatcalculator.core.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VatCalculationInputDataCheckerUnitTest {

    private VatCalculationInputDataChecker inputDataChecker;

    @BeforeEach
    void setUp() {
        inputDataChecker = new VatCalculationInputDataChecker();
    }

    @Test
    void positiveTest() {
        var vatCalculation = new VatCalculation(new VatPercentage("20"),
                new NetAmount((String) null), new GrossAmount("20"), new VatAmount((String) null));
        assertDoesNotThrow(() -> inputDataChecker.validate(vatCalculation));
    }

    @Test
    void moreThanOneAmountIsGivenTest() {
        var vatCalculation = new VatCalculation(new VatPercentage("20"),
                new NetAmount("20"), new GrossAmount("20"), new VatAmount((String) null));
        assertThrows(BadRequestException.class, () -> inputDataChecker.validate(vatCalculation));
    }

    @Test
    void noAmountIsGivenTest() {
        var vatCalculation = new VatCalculation(new VatPercentage("20"),
                new NetAmount((String) null), new GrossAmount((String) null), new VatAmount((String) null));
        assertThrows(BadRequestException.class, () -> inputDataChecker.validate(vatCalculation));
    }
}
