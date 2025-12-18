package com.baeldung.ls;

import com.baeldung.ls.persistence.model.PirateCrew;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LsApp {

    private static final Logger LOG = LoggerFactory.getLogger(LsApp.class);

    @Value("${additional.info}")
    private String additional;
    @Autowired
    private PirateCrew pirateCrew;

    public static void main(final String... args) {
        SpringApplication.run(LsApp.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("Additional property {}", additional);
        LOG.info("@Configuration properties example with Mugiwara: " + pirateCrew);
    }

}
