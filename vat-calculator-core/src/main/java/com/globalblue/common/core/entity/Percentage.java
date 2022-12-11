package com.globalblue.common.core.entity;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public abstract class Percentage extends DecimalNumber {

    protected Percentage(String name, Boolean isMandatory, String value) {
        super(name, isMandatory, value);
    }

    @Override
    protected BigDecimal convert(String value) {
        return super.convert(value).divide(new BigDecimal("100"), 2, HALF_UP);
    }
}
