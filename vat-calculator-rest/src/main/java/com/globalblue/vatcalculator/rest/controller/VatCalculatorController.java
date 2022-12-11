package com.globalblue.vatcalculator.rest.controller;

import com.globalblue.common.rest.controller.BaseController;
import com.globalblue.logger.Logger;
import com.globalblue.vatcalculator.rest.service.VatCalculatorService;
import com.globalblue.vatcalculator.rest.view.VatCalculationRequestDto;
import com.globalblue.vatcalculator.rest.view.VatCalculationResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
class VatCalculatorController extends BaseController<VatCalculationRequestDto, VatCalculationResponseDto> {

    private final VatCalculatorService service;

    public VatCalculatorController(VatCalculatorService service, Logger logger) {
        super(logger);
        this.service = service;
    }

    @PostMapping("/v1/vat_calculation")
    public VatCalculationResponseDto calculateVat(
            @RequestHeader("x-request-id")
                    String requestId,
            @RequestBody VatCalculationRequestDto dto) {
        return callService(service::calculateVat, dto, requestId);
    }
}