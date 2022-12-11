package com.globalblue.vatcalculator.core.entity;

import java.math.BigDecimal;

public class VatAmount extends VatCalculationDecimalNumber {

    public VatAmount(String value) {
        super("VAT_AMOUNT", false, value);
    }

    public VatAmount(BigDecimal value) {
        super("VAT_AMOUNT", false, value);
    }

    public VatAmount(VatPercentage vatPercentage, NetAmount netAmount) {
        this(netAmount.value.multiply(vatPercentage.value));
    }
}