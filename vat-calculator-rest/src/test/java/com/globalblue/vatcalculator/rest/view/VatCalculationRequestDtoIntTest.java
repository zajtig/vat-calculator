package com.globalblue.vatcalculator.rest.view;

import com.globalblue.vatcalculator.core.entity.VatCalculation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VatCalculationRequestDtoIntTest {

    @Test
    void createTest() {
        var requestDto = createRequestDto();
        assertEquals("20", requestDto.vatPercentage);
        assertEquals("200", requestDto.vatAmount);
        assertEquals("1000", requestDto.netAmount);
        assertEquals("1200", requestDto.grossAmount);
    }

    @Test
    void mapToEntity() {
        var requestDto = createRequestDto();
        VatCalculation vatCalculation = requestDto.mapToEntity();
        assertEquals(new BigDecimal("0.20"), vatCalculation.vatPercentage().value);
        assertEquals(new BigDecimal("200"), vatCalculation.vatAmount().value);
        assertEquals(new BigDecimal("1000"), vatCalculation.netAmount().value);
        assertEquals(new BigDecimal("1200"), vatCalculation.grossAmount().value);
    }

    private VatCalculationRequestDto createRequestDto() {
        return new VatCalculationRequestDto()
                .setVatPercentage("20")
                .setVatAmount("200")
                .setNetAmount("1000")
                .setGrossAmount("1200");
    }
}
