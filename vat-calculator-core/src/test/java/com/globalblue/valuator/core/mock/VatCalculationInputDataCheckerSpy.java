package com.globalblue.valuator.core.mock;

import com.globalblue.vatcalculator.core.command.VatCalculationInputDataChecker;
import com.globalblue.vatcalculator.core.entity.VatCalculation;

public class VatCalculationInputDataCheckerSpy extends VatCalculationInputDataChecker {

    public boolean isValidateCalled;

    @Override
    public void validate(VatCalculation input) {
        isValidateCalled = true;
    }
}
