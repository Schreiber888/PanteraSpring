package com.javarush.pantera.lesson03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static com.javarush.pantera.lesson03.config.Config.BASE_PACKAGE;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(BASE_PACKAGE)
public class Config {

    public static final String BASE_PACKAGE = "com.javarush.pantera.lesson03";

    @Bean
    public SessionCreator getSessionCreator(ApplicationProperties applicationProperties) {
        return new SessionCreator(applicationProperties);
    }


}
