package com.baeldung.ls.persistence.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.boot.context.properties.bind.Name;

@ConfigurationProperties("pirate-crew")
public record Equipage(String captain, @Name("first-mate") String firstMate, String navigator,
                       String sniper, String cook, String doctor, String historian, Integer number) {

    @ConstructorBinding
    public Equipage {
        number = 10;
    }
}
