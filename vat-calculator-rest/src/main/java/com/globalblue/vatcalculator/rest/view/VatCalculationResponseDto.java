package com.globalblue.vatcalculator.rest.view;

import com.globalblue.common.rest.view.DataStructure;
import com.globalblue.vatcalculator.core.entity.VatCalculation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VatCalculationResponseDto extends DataStructure {

    public BigDecimal vatPercentage;
    public BigDecimal netAmount;
    public BigDecimal grossAmount;
    public BigDecimal vatAmount;

    public VatCalculationResponseDto() {
    }

    public VatCalculationResponseDto(VatCalculation entity) {
        vatAmount = entity.vatAmount().value.setScale(2, RoundingMode.HALF_UP);
        grossAmount = entity.grossAmount().value.setScale(2, RoundingMode.HALF_UP);
        netAmount = entity.netAmount().value.setScale(2, RoundingMode.HALF_UP);
        vatPercentage = entity.vatPercentage().value;
    }
}
