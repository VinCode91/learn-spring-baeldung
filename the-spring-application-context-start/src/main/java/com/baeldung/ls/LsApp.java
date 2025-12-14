package com.baeldung.ls;

import com.baeldung.ls.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
//@EnableAutoConfiguration // @EnableAuto
public class LsApp {
    private static final Logger LOG = LoggerFactory.getLogger(LsApp.class);

    public static void main(final String... args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(LsApp.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.baeldung.ls.persistence.repository");
        LOG.info("context created with id {}", ctx.getId());
        // Following works since beans present in repository package are already registered in context
        ctx.scan("com.baeldung.ls.service");
        IProjectService projectService = ctx.getBean("projectServiceImpl", IProjectService.class);

        LOG.info("{}", projectService.findById(1L));

        LOG.info("Context active before close: {}", ctx.isActive());

        ctx.close();

        LOG.info("Context active after close: {}", ctx.isActive());

        // Following throws IllegalStateException since context was already closed
        try {
            ctx.getBean("projectServiceImpl", IProjectService.class);
        } catch (IllegalStateException e) {
            LOG.error("custom context is already closed!", e);
        }

        IProjectService projectService2 = appContext.getBean("projectServiceImpl", IProjectService.class);
        LOG.info("{}", projectService2.findById(1L));

    }

}
