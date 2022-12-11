package com.globalblue.vatcalculator.core.core;

import com.globalblue.common.core.Presenter;
import com.globalblue.common.core.exception.CoreException;
import com.globalblue.vatcalculator.core.entity.VatCalculation;

public interface VatCalculatorPresenter extends Presenter {

    void deliver(VatCalculation vatCalculation);

    void deliverError(CoreException coreException);
}
