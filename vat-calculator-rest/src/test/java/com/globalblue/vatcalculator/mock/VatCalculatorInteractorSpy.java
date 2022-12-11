package com.globalblue.vatcalculator.mock;

import com.globalblue.vatcalculator.core.core.VatCalculatorInteractor;
import com.globalblue.vatcalculator.core.core.VatCalculatorPresenter;
import com.globalblue.vatcalculator.core.entity.*;

import java.math.BigDecimal;

public class VatCalculatorInteractorSpy implements VatCalculatorInteractor {

    public boolean isCalculateVatCalled;

    @Override
    public void calculateVat(VatCalculation vatCalculation, VatCalculatorPresenter presenter) {
        isCalculateVatCalled = true;
        presenter.deliver(new VatCalculation(new VatPercentage("20"), new NetAmount(new BigDecimal("20")),
                new GrossAmount(new BigDecimal("20")), new VatAmount(new BigDecimal("20"))));
    }
}