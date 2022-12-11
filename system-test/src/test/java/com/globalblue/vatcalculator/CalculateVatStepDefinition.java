package com.globalblue.vatcalculator;

import com.globalblue.vatcalculator.rest.view.VatCalculationRequestDto;
import com.globalblue.vatcalculator.rest.view.VatCalculationResponseDto;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

public class CalculateVatStepDefinition {

    private final DomainHelper domainHelper = DomainHelper.getInstance();
    @Steps
    private VatCalculatirApiHelper vatCalculatirApiHelper;

    @When("I call the API with the Net amount and the VAT percentage")
    public void vatCalculation1() {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("20")
                .setNetAmount("1000"));
    }

    @When("I call the API with the VAT amount and the VAT percentage")
    public void vatCalculation2() {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("20")
                .setVatAmount("1000"));
    }

    @When("I call the API with the Gross amount and the VAT percentage")
    public void vatCalculation3() {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("20")
                .setGrossAmount("1000"));
    }

    @Then("I receive the result of the full calculation")
    public void vatCalculation4() {
        assertEquals(OK, domainHelper.getHttpStatus());
        assertAllCalculationGiven(domainHelper.getResponseAs(VatCalculationResponseDto.class));
    }

    @When("I call the API with a text value instead of a number")
    public void vatCalculation5() {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("TEXT"));
    }

    @When("I call the API with a 0 value")
    public void vatCalculation6() {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("0"));
    }

    @When("I call the API with an empty VAT percentage")
    public void vatCalculation7() {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage(null));
    }

    @When("I call the API with more than one amount")
    public void vatCalculation8() {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("10.23")
                .setVatAmount("1")
                .setGrossAmount("2")
        );
    }

    @When("I call the API without any amount")
    public void vatCalculation9() {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("10.23")
        );
    }

    @When("I call the API with {} VAT amount")
    public void vatCalculation10(String vatAmount) {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("20")
                .setVatAmount(vatAmount)
        );
    }

    @When("I call the API with {} Gross amount")
    public void vatCalculation11(String gross) {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("20")
                .setGrossAmount(gross)
        );
    }

    @When("I call the API with {} Net amount")
    public void vatCalculation12(String netAmount) {
        vatCalculatirApiHelper.callCalculateVat(new VatCalculationRequestDto()
                .setVatPercentage("20")
                .setNetAmount(netAmount)
        );
    }

    @Then("I receive the {} VAT amount")
    public void vatCalculation13(BigDecimal expectedVatAmount) {
        assertEquals(OK, domainHelper.getHttpStatus());
        assertEquals(expectedVatAmount, domainHelper.getResponseAs(VatCalculationResponseDto.class).vatAmount);
    }

    @Then("I receive the {} Gross amount")
    public void vatCalculation14(BigDecimal expectedGrossAmount) {
        assertEquals(OK, domainHelper.getHttpStatus());
        assertEquals(expectedGrossAmount, domainHelper.getResponseAs(VatCalculationResponseDto.class).grossAmount);
    }

    @Then("I receive the {} Net amount")
    public void vatCalculation15(BigDecimal expectedNetAmount) {
        assertEquals(OK, domainHelper.getHttpStatus());
        assertEquals(expectedNetAmount, domainHelper.getResponseAs(VatCalculationResponseDto.class).netAmount);
    }

    @Then("I receive the {} error code")
    public void vatCalculation16(String errorCode) {
        assertEquals(BAD_REQUEST, domainHelper.getHttpStatus());
        assertTrue(domainHelper.getErrorCode().contains(errorCode));
    }

    private void assertAllCalculationGiven(VatCalculationResponseDto response) {
        assertNotNull(response.vatPercentage);
        assertNotNull(response.vatAmount);
        assertNotNull(response.netAmount);
        assertNotNull(response.grossAmount);
    }
}