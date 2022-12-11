package com.globalblue.vatcalculator;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import static com.globalblue.vatcalculator.PackageDefinitions.VAT_CALCULATOR_REST_CONFIGURATION;
import static com.globalblue.vatcalculator.PackageDefinitions.VAT_CALCULATOR_REST_CONTROLLER;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(
        packages = "com.globalblue.vatcalculator",
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class RestTest {

    @ArchTest
    public static final ArchRule controller_method_implementations_use_spring_web_annotation = methods()
            .that().arePublic()
            .and().areDeclaredInClassesThat().resideInAPackage(VAT_CALCULATOR_REST_CONTROLLER)
            .should().beAnnotatedWith(GetMapping.class)
            .orShould().beAnnotatedWith(PostMapping.class)
            .orShould().beAnnotatedWith(PutMapping.class)
            .orShould().beAnnotatedWith(DeleteMapping.class);

    @ArchTest
    public static final ArchRule controller_class_implementations_use_spring_web_annotations = classes()
            .that().resideInAPackage(VAT_CALCULATOR_REST_CONTROLLER)
            .should().beAnnotatedWith(RestController.class);
    @ArchTest
    public static final ArchRule config_class_implementations_use_spring_config_annotation = classes()
            .that().resideInAPackage(VAT_CALCULATOR_REST_CONFIGURATION)
            .and().haveSimpleNameEndingWith("Configuration")
            .should().beAnnotatedWith(Configuration.class);
}
