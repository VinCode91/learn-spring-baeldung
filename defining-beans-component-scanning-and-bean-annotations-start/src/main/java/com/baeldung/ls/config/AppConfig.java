package com.baeldung.ls.config;

import com.baeldung.ls.persistence.PersistenceConfig;
import com.baeldung.ls.service.ServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({PersistenceConfig.class, ServiceConfig.class})
@Configuration
public class AppConfig {
}
