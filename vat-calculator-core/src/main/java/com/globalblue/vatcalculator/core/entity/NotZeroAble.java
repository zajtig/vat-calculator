package com.globalblue.vatcalculator.core.entity;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

public interface NotZeroAble {

    default void chekZero(BigDecimal value, String errorCode) {
        if (nonNull(value) && BigDecimal.ZERO.compareTo(value) == 0) {
            throw new IllegalArgumentException(errorCode);
        }
    }
}
