package com.globalblue.common.core.entity;

import java.math.BigDecimal;

import static org.apache.commons.lang3.StringUtils.isBlank;

public abstract class DecimalNumber extends BaseProperty<BigDecimal> {

    protected static final String HAS_INVALID_VALUE = "HAS_INVALID_VALUE";

    protected DecimalNumber(String name, Boolean isMandatory, String value) {
        super(name, isMandatory, value);
    }

    protected DecimalNumber(String name, Boolean isMandatory, BigDecimal value) {
        super(name, isMandatory, value);
    }

    protected BigDecimal convert(String value) {
        return isBlank(value) ? null : convertNotNullValue(value);
    }

    private BigDecimal convertNotNullValue(String value) {
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s_%s", name, HAS_INVALID_VALUE));
        }
    }
}
