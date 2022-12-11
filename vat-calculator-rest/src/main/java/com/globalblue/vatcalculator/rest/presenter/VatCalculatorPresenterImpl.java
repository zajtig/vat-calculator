package com.globalblue.vatcalculator.rest.presenter;

import com.globalblue.common.rest.presenter.BasePresenter;
import com.globalblue.vatcalculator.core.core.VatCalculatorPresenter;
import com.globalblue.vatcalculator.core.entity.VatCalculation;
import com.globalblue.vatcalculator.rest.view.VatCalculationResponseDto;

public class VatCalculatorPresenterImpl extends BasePresenter implements VatCalculatorPresenter {

    public VatCalculationResponseDto getVatCalculationResponseDto() {
        return map(VatCalculationResponseDto::new, getResponseAs(VatCalculation.class));
    }

    @Override
    public void deliver(VatCalculation vatCalculation) {
        deliverResponse(vatCalculation);
    }
}