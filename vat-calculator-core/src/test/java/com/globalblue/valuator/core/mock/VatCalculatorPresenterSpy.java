package com.globalblue.valuator.core.mock;

import com.globalblue.common.core.exception.CoreException;
import com.globalblue.vatcalculator.core.core.VatCalculatorPresenter;
import com.globalblue.vatcalculator.core.entity.VatCalculation;

public class VatCalculatorPresenterSpy implements VatCalculatorPresenter {

    public VatCalculation vatCalculation;
    public CoreException coreException;

    @Override
    public void deliver(VatCalculation vatCalculation) {
        this.vatCalculation = vatCalculation;
    }

    @Override
    public void deliverError(CoreException coreException) {
        this.coreException = coreException;
    }
}
