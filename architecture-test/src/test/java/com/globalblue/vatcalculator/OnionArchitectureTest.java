package com.globalblue.vatcalculator;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.globalblue.vatcalculator.PackageDefinitions.*;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(
        packages = "com.globalblue",
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class OnionArchitectureTest {

    @ArchTest
    static final ArchRule onion_architecture_is_respected = onionArchitecture()
            .domainModels(COMMON_CORE_ENTITY, COMMON_CORE_EXCEPTION,
                    VAT_CALCULATOR_CORE_ENTITY)
            .domainServices(COMMON_CORE_COMMAND, COMMON_CORE_ROOT,
                    VAT_CALCULATOR_CORE_COMMAND, VAT_CALCULATOR_CORE_CORE_ROOT)
            .applicationServices(COMMON_REST_SERVICE, COMMON_REST_PRESENTER, COMMON_REST_EXCEPTION, COMMON_REST_VIEW,
                    VAT_CALCULATOR_REST_SERVICE, VAT_CALCULATOR_REST_PRESENTER, VAT_CALCULATOR_REST_VIEW)
            .adapter("rest", COMMON_REST_CONTROLLER, COMMON_REST_CONFIGURATION,
                    VAT_CALCULATOR_REST_CONTROLLER, VAT_CALCULATOR_REST_CONFIGURATION);

}