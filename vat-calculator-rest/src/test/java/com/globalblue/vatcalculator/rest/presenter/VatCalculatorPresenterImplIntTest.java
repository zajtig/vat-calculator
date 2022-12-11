package com.globalblue.vatcalculator.rest.presenter;

import com.globalblue.vatcalculator.core.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class VatCalculatorPresenterImplIntTest {

    private VatCalculatorPresenterImpl presenter;

    @BeforeEach
    void setUp() {
        presenter = new VatCalculatorPresenterImpl();
    }

    @Test
    void deliverAndGetTest() {
        presenter.deliver(new VatCalculation(new VatPercentage("20"), new NetAmount(new BigDecimal("20")),
                new GrossAmount(new BigDecimal("20")), new VatAmount(new BigDecimal("20"))));
        assertNotNull(presenter.getVatCalculationResponseDto());
    }
}
