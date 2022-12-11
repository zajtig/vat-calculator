package com.globalblue.valuator.core.core;

import com.globalblue.common.core.mock.LoggerMock;
import com.globalblue.valuator.core.mock.VatCalculatorPresenterSpy;
import com.globalblue.vatcalculator.core.command.VatCalculationInputDataChecker;
import com.globalblue.vatcalculator.core.core.VatCalculatorInteractorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class VatCalculatorInteractorImplIntTest {

    private VatCalculatorInteractorImpl interactor;
    private VatCalculatorPresenterSpy presenterSpy;

    @BeforeEach
    void setUp() {
        presenterSpy = new VatCalculatorPresenterSpy();
        interactor = new VatCalculatorInteractorImpl(new LoggerMock(), new VatCalculationInputDataChecker());
    }

    @Test
    void calculateVatTest() {
        interactor.calculateVat(null, presenterSpy);
        assertNotNull(presenterSpy.coreException);
    }
}
