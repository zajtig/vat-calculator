package com.globalblue.vatcalculator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringUtil {

    private static ConfigurableApplicationContext instance;

    public static void start() {
        startMicroservice();
    }

    private static ConfigurableApplicationContext startMicroservice() {
        return instance = new SpringApplicationBuilder(VatCalculatorApplication.class).run();
    }

    public static void stop() {
        instance.stop();
    }
}
