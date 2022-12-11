package com.globalblue.vatcalculator.core.entity;

import java.math.BigDecimal;

import static java.math.RoundingMode.DOWN;

public class NetAmount extends VatCalculationDecimalNumber {

    public NetAmount(String value) {
        super("NET_AMOUNT", false, value);
    }

    public NetAmount(BigDecimal value) {
        super("NET_AMOUNT", false, value);
    }

    public NetAmount(VatPercentage vatPercentage, VatAmount vatAmount) {
        this(vatAmount.value.divide(vatPercentage.value, 10, DOWN));
    }

    public NetAmount(VatPercentage vatPercentage, GrossAmount grossAmount) {
        this(grossAmount.value.divide(BigDecimal.ONE.add(vatPercentage.value), 10, DOWN));
    }
}
