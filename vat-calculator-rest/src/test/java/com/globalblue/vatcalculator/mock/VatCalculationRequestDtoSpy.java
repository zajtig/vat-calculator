package com.globalblue.vatcalculator.mock;

import com.globalblue.vatcalculator.core.entity.*;
import com.globalblue.vatcalculator.rest.view.VatCalculationRequestDto;

import java.math.BigDecimal;

public class VatCalculationRequestDtoSpy extends VatCalculationRequestDto {

    public boolean isMapToEntityCalled;

    @Override
    public VatCalculation mapToEntity() {
        isMapToEntityCalled = true;
        return new VatCalculation(new VatPercentage("20"), new NetAmount(new BigDecimal("20")),
                new GrossAmount(new BigDecimal("20")), new VatAmount(new BigDecimal("20")));
    }
}
