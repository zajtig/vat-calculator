package com.globalblue.vatcalculator.rest.view;

import com.globalblue.common.rest.view.DataStructure;
import com.globalblue.common.rest.view.RequestDto;
import com.globalblue.vatcalculator.core.entity.*;

public class VatCalculationRequestDto extends DataStructure implements RequestDto<VatCalculation> {

    public String vatPercentage;
    public String netAmount;
    public String grossAmount;
    public String vatAmount;

    public VatCalculationRequestDto setVatPercentage(String vatPercentage) {
        this.vatPercentage = vatPercentage;
        return this;
    }

    public VatCalculationRequestDto setNetAmount(String netAmount) {
        this.netAmount = netAmount;
        return this;
    }

    public VatCalculationRequestDto setGrossAmount(String grossAmount) {
        this.grossAmount = grossAmount;
        return this;
    }

    public VatCalculationRequestDto setVatAmount(String vatAmount) {
        this.vatAmount = vatAmount;
        return this;
    }

    @Override
    public VatCalculation mapToEntity() {
        return new VatCalculation(
                new VatPercentage(vatPercentage),
                new NetAmount(netAmount),
                new GrossAmount(grossAmount),
                new VatAmount(vatAmount)
        );
    }
}