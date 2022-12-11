package com.globalblue.vatcalculator.mock;

import com.globalblue.vatcalculator.rest.service.VatCalculatorService;
import com.globalblue.vatcalculator.rest.view.VatCalculationRequestDto;
import com.globalblue.vatcalculator.rest.view.VatCalculationResponseDto;

public class VatCalculatorServiceSpy extends VatCalculatorService {

    public boolean isCalculateVatCalled;

    public VatCalculatorServiceSpy() {
        super(null);
    }

    @Override
    public VatCalculationResponseDto calculateVat(VatCalculationRequestDto dto) {
        isCalculateVatCalled = true;
        return new VatCalculationResponseDto();
    }
}
