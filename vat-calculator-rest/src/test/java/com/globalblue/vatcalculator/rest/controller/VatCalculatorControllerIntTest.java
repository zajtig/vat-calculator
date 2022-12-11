package com.globalblue.vatcalculator.rest.controller;

import com.globalblue.vatcalculator.mock.LoggerMock;
import com.globalblue.vatcalculator.mock.VatCalculationRequestDtoSpy;
import com.globalblue.vatcalculator.mock.VatCalculatorServiceSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VatCalculatorControllerIntTest {

    private VatCalculatorController controller;
    private VatCalculatorServiceSpy serviceSpy;

    @BeforeEach
    void setUp() {
        serviceSpy = new VatCalculatorServiceSpy();
        controller = new VatCalculatorController(serviceSpy, new LoggerMock());
    }

    @Test
    void calculateVatTest() {
        assertNotNull(controller.calculateVat(UUID.randomUUID().toString(), new VatCalculationRequestDtoSpy()));
        assertTrue(serviceSpy.isCalculateVatCalled);
    }
}