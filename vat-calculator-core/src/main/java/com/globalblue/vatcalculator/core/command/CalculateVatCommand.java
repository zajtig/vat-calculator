package com.globalblue.vatcalculator.core.command;

import com.globalblue.common.core.command.BaseCommand;
import com.globalblue.logger.Logger;
import com.globalblue.vatcalculator.core.core.VatCalculatorPresenter;
import com.globalblue.vatcalculator.core.entity.*;

public class CalculateVatCommand extends BaseCommand {

    private final VatCalculation input;
    private final VatCalculatorPresenter presenter;
    private final VatCalculationInputDataChecker inputDataChecker;

    public CalculateVatCommand(VatCalculatorPresenter presenter,
                               VatCalculationInputDataChecker inputDataChecker,
                               Logger logger,
                               VatCalculation input
    ) {
        super(presenter, logger);
        this.presenter = presenter;
        this.inputDataChecker = inputDataChecker;
        this.input = input;
    }

    @Override
    protected void executeInner() {
        inputDataChecker.validate(input);
        presenter.deliver(doCalculate(input.vatPercentage()));
    }

    private VatCalculation doCalculate(VatPercentage vatPercentage) {
        var netAmount = calculateNetAmount();
        var vatAmount = new VatAmount(vatPercentage, netAmount);
        var grossAmount = new GrossAmount(netAmount, vatAmount);
        return new VatCalculation(vatPercentage, netAmount, grossAmount, vatAmount);
    }

    private NetAmount calculateNetAmount() {
        if (input.vatAmount().isPresent()) {
            return new NetAmount(input.vatPercentage(), input.vatAmount());
        } else if (input.grossAmount().isPresent()) {
            return new NetAmount(input.vatPercentage(), input.grossAmount());
        }
        return new NetAmount(input.netAmount().value);
    }
}