package com.baeldung.ls.config;

import com.baeldung.ls.persistence.model.PirateCrew;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource({"classpath:additional.properties"})
@Configuration
public class AppConfig {
    @Bean
    @ConfigurationProperties(prefix = "pirate-crew")
    PirateCrew pirateCrew() {
        return new PirateCrew();
    }
}
