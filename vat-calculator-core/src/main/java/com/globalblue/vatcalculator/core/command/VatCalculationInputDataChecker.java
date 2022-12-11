package com.globalblue.vatcalculator.core.command;

import com.globalblue.common.core.entity.BaseProperty;
import com.globalblue.common.core.exception.BadRequestException;
import com.globalblue.vatcalculator.core.entity.VatCalculation;

import java.util.stream.Stream;

public class VatCalculationInputDataChecker {

    private static final String ONE_OF_THE_AMOUNTS_IS_MANDATORY = "ONE_OF_THE_AMOUNTS_IS_MANDATORY";
    private static final String MORE_THAN_ONE_AMOUNT_IS_GIVEN = "MORE_THAN_ONE_AMOUNT_IS_GIVEN";

    public void validate(VatCalculation input) {
        checkAmountMandatory(input);
        checkMoreThanOneAmount(input);
    }

    private void checkMoreThanOneAmount(VatCalculation input) {
        if (Stream.of(input.netAmount(), input.grossAmount(), input.vatAmount())
                .filter(BaseProperty::isPresent).count() > 1) {
            throw new BadRequestException(MORE_THAN_ONE_AMOUNT_IS_GIVEN);
        }
    }

    private void checkAmountMandatory(VatCalculation input) {
        if (Stream.of(input.netAmount(), input.grossAmount(), input.vatAmount())
                .noneMatch(BaseProperty::isPresent)) {
            throw new BadRequestException(ONE_OF_THE_AMOUNTS_IS_MANDATORY);
        }
    }
}