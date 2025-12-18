package com.baeldung.ls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LsApp {

    private static final Logger LOG = LoggerFactory.getLogger(LsApp.class);

    public static void main(final String... args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(LsApp.class, args);
        LOG.info("APPLICATION STARTUP FINISHED");
    }

}
