package com.globalblue.vatcalculator.rest.configuration;

import com.globalblue.logger.Logger;
import com.globalblue.logger.LoggerImpl;
import com.globalblue.vatcalculator.core.command.VatCalculationInputDataChecker;
import com.globalblue.vatcalculator.core.core.VatCalculatorInteractor;
import com.globalblue.vatcalculator.core.core.VatCalculatorInteractorImpl;
import com.globalblue.vatcalculator.rest.service.VatCalculatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class VatCalculatorConfiguration {

    @Bean
    public VatCalculatorService service(VatCalculatorInteractor interactor) {
        return new VatCalculatorService(interactor);
    }

    @Bean
    public VatCalculatorInteractor interactor(Logger logger,
                                              VatCalculationInputDataChecker inputDataChecker) {
        return new VatCalculatorInteractorImpl(logger, inputDataChecker);
    }

    @Bean
    public VatCalculationInputDataChecker inputDataChecker() {
        return new VatCalculationInputDataChecker();
    }

    @Bean
    public Logger logger() {
        return new LoggerImpl();
    }
}