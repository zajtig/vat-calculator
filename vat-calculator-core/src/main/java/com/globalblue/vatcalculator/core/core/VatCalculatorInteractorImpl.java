package com.globalblue.vatcalculator.core.core;

import com.globalblue.logger.Logger;
import com.globalblue.vatcalculator.core.command.CalculateVatCommand;
import com.globalblue.vatcalculator.core.command.VatCalculationInputDataChecker;
import com.globalblue.vatcalculator.core.entity.VatCalculation;

public class VatCalculatorInteractorImpl implements VatCalculatorInteractor {

    private final Logger logger;
    private final VatCalculationInputDataChecker inputDataChecker;

    public VatCalculatorInteractorImpl(Logger logger, VatCalculationInputDataChecker inputDataChecker) {
        this.logger = logger;
        this.inputDataChecker = inputDataChecker;
    }

    @Override
    public void calculateVat(VatCalculation input, VatCalculatorPresenter presenter) {
        new CalculateVatCommand(presenter, inputDataChecker, logger, input)
                .execute();
    }
}