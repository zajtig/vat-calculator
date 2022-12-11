package com.globalblue.vatcalculator.core.entity;

import com.globalblue.common.core.entity.Percentage;

import java.math.BigDecimal;

public class VatCalculationPercentage extends Percentage implements NotZeroAble {

    public VatCalculationPercentage(String name, Boolean isMandatory, String value) {
        super(name, isMandatory, value);
    }

    @Override
    protected BigDecimal convert(String value) {
        BigDecimal result = super.convert(value);
        chekZero(result, String.format("%s_%s", name, HAS_INVALID_VALUE));
        return result;
    }
}
