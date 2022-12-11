package com.globalblue.vatcalculator.core.entity;

public record VatCalculation(VatPercentage vatPercentage,
                             NetAmount netAmount,
                             GrossAmount grossAmount,
                             VatAmount vatAmount) {

}