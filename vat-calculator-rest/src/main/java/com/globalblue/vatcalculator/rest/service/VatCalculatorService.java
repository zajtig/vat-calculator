package com.globalblue.vatcalculator.rest.service;

import com.globalblue.common.rest.service.BaseService;
import com.globalblue.vatcalculator.core.core.VatCalculatorInteractor;
import com.globalblue.vatcalculator.rest.presenter.VatCalculatorPresenterImpl;
import com.globalblue.vatcalculator.rest.view.VatCalculationRequestDto;
import com.globalblue.vatcalculator.rest.view.VatCalculationResponseDto;

public class VatCalculatorService extends BaseService {

    private final VatCalculatorInteractor interactor;

    public VatCalculatorService(VatCalculatorInteractor interactor) {
        this.interactor = interactor;
    }

    public VatCalculationResponseDto calculateVat(VatCalculationRequestDto dto) {
        var presenter = new VatCalculatorPresenterImpl();
        interactor.calculateVat(map(dto::mapToEntity), presenter);
        return presenter.getVatCalculationResponseDto();
    }
}