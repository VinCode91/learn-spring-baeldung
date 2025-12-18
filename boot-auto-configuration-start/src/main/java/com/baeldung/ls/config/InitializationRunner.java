package com.baeldung.ls.config;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@Order(0)
public class InitializationRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(InitializationRunner.class);

    @Autowired
    private IProjectService projectService;
    @Override
    public void run(String... args) throws Exception {
        projectService.save(new Project(1L,"Project 1", LocalDate.now()));

        Optional<Project> project = projectService.findById(1L);

        LOG.info("Project {}", project.toString());
    }
}
