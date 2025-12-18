package com.baeldung.ls.config;

import com.baeldung.ls.persistence.model.Equipage;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource({"classpath:additional.properties"})
@Configuration
@EnableConfigurationProperties({Equipage.class})
public class AppConfig {
}
