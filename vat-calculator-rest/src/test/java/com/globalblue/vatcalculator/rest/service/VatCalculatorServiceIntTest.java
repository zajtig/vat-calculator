package com.globalblue.vatcalculator.rest.service;

import com.globalblue.vatcalculator.mock.VatCalculationRequestDtoSpy;
import com.globalblue.vatcalculator.mock.VatCalculatorInteractorSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VatCalculatorServiceIntTest {

    private VatCalculatorService service;
    private VatCalculatorInteractorSpy interactorSpy;
    private VatCalculationRequestDtoSpy requestDtoSpy;

    @BeforeEach
    void setUp() {
        interactorSpy = new VatCalculatorInteractorSpy();
        service = new VatCalculatorService(interactorSpy);
        requestDtoSpy = new VatCalculationRequestDtoSpy();
    }

    @Test
    void calculateVatTest() {
        assertNotNull(service.calculateVat(requestDtoSpy));
        assertTrue(requestDtoSpy.isMapToEntityCalled);
        assertTrue(interactorSpy.isCalculateVatCalled);
    }
}
