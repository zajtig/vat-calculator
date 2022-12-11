package com.globalblue.vatcalculator.core.core;

import com.globalblue.vatcalculator.core.entity.VatCalculation;

public interface VatCalculatorInteractor {

    void calculateVat(VatCalculation vatCalculation, VatCalculatorPresenter presenter);
}
