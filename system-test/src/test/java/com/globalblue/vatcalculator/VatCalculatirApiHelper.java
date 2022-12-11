package com.globalblue.vatcalculator;

import com.globalblue.vatcalculator.rest.view.VatCalculationRequestDto;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import net.thucydides.core.annotations.Step;

import java.util.UUID;

import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.given;

public class VatCalculatirApiHelper {

    public static final String HOST = "http://localhost";

    public VatCalculatirApiHelper() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(HOST)
                .build();
    }

    @Step("API call: v1/vat_calculation")
    public void callCalculateVat(VatCalculationRequestDto dto) {
        DomainHelper.getInstance().setActualResponse(new ResponseWrapper(
                given()
                        .port(8080)
                        .basePath("/v1/vat_calculation")
                        .header("x-request-id", UUID.randomUUID().toString())
                        .body(dto)
                        .post()));
    }
}