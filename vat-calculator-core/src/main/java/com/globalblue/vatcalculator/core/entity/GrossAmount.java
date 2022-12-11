package com.globalblue.vatcalculator.core.entity;

import java.math.BigDecimal;

public class GrossAmount extends VatCalculationDecimalNumber {

    public GrossAmount(String value) {
        super("GROSS_AMOUNT", false, value);
    }

    public GrossAmount(BigDecimal value) {
        super("GROSS_AMOUNT", false, value);
    }

    public GrossAmount(NetAmount netAmount, VatAmount vatAmount) {
        this(netAmount.value.add(vatAmount.value));
    }
}
