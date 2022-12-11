package com.globalblue.valuator.core.command;

import com.globalblue.common.core.mock.LoggerMock;
import com.globalblue.valuator.core.mock.VatCalculationInputDataCheckerSpy;
import com.globalblue.valuator.core.mock.VatCalculatorPresenterSpy;
import com.globalblue.vatcalculator.core.command.CalculateVatCommand;
import com.globalblue.vatcalculator.core.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculateVatCommandIntTest {

    private VatCalculatorPresenterSpy presenterSpy;
    private VatCalculationInputDataCheckerSpy inputDataCheckerSpy;
    private LoggerMock loggerMock;

    @BeforeEach
    void setUp() {
        presenterSpy = new VatCalculatorPresenterSpy();
        loggerMock = new LoggerMock();
        inputDataCheckerSpy = new VatCalculationInputDataCheckerSpy();
    }

    @Test
    void calculatedByNetAmountTest() {
        VatCalculation vatCalculation = new VatCalculation(new VatPercentage("20"),
                new NetAmount(new BigDecimal("20")), new GrossAmount((String) null), new VatAmount((String) null));
        createCommand(vatCalculation).execute();
        assertTrue(inputDataCheckerSpy.isValidateCalled);
        assertNotNull(presenterSpy.vatCalculation);
    }

    @Test
    void calculatedByGrossAmountTest() {
        VatCalculation vatCalculation = new VatCalculation(new VatPercentage("20"),
                new NetAmount((String) null), new GrossAmount("1000"), new VatAmount((String) null));
        createCommand(vatCalculation).execute();
        assertTrue(inputDataCheckerSpy.isValidateCalled);
        assertNotNull(presenterSpy.vatCalculation);
    }

    @Test
    void calculatedByVatAmountTest() {
        VatCalculation vatCalculation = new VatCalculation(new VatPercentage("20"),
                new NetAmount((String) null), new GrossAmount((String) null), new VatAmount("20"));
        createCommand(vatCalculation).execute();
        assertTrue(inputDataCheckerSpy.isValidateCalled);
        assertNotNull(presenterSpy.vatCalculation);
    }

    private CalculateVatCommand createCommand(VatCalculation vatCalculation) {
        return new CalculateVatCommand(presenterSpy, inputDataCheckerSpy, loggerMock, vatCalculation);
    }
}