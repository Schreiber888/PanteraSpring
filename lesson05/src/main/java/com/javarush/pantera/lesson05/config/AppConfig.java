package com.javarush.pantera.lesson05.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Set;

@Data
@Configuration
@ConfigurationProperties(prefix = "pantera.jpa")
@ToString
public class AppConfig {

    private int tryCount = -1;
    private String url = "jdbc:mysql://localhost:3306/default";
    private Set<String> set;
    private Long[] array;
    private Map<Long, String> map;
}
