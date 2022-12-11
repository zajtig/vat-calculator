package com.globalblue.vatcalculator.core.entity;

import com.globalblue.common.core.entity.DecimalNumber;

import java.math.BigDecimal;

public class VatCalculationDecimalNumber extends DecimalNumber implements NotZeroAble {

    public VatCalculationDecimalNumber(String name, Boolean isMandatory, String value) {
        super(name, isMandatory, value);
    }

    public VatCalculationDecimalNumber(String name, Boolean isMandatory, BigDecimal value) {
        super(name, isMandatory, value);
    }

    @Override
    public BigDecimal convert(String value) {
        BigDecimal result = super.convert(value);
        chekZero(result, String.format("%s_%s", name, HAS_INVALID_VALUE));
        return result;
    }
}
