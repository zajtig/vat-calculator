package com.globalblue.vatcalculator;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "com/globalblue/vatcalculator",
        plugin = {"progress", "json:target/test-classes/cucumber.json"},
        monochrome = (true),
        stepNotifications = true)
public class SystemTest {

    @BeforeClass
    public static void before() {
        SpringUtil.start();
    }

    @AfterClass
    public static void after() {
        SpringUtil.stop();
    }
}
