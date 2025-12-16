package com.baeldung.ls.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    private static Logger LOG = LoggerFactory.getLogger(ProjectRepositoryImpl.class);

    // Using property map requires SpEL
    @Value("#{${pre-suffix-map}}")
    private Map<String, String> propertyMap;

    private List<Project> projects = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        updateInternalId(project);
        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }

    private void updateInternalId(Project project) {
        LOG.info("Prepending Prefix " + propertyMap.get("prefix"));
        LOG.info("Appending Suffix " + propertyMap.get("suffix"));

        project.setInternalId(propertyMap.get("prefix") + "-" + project.getId() + "-" + propertyMap.get("suffix"));

        LOG.info("Generated internal id " + project.getInternalId());
    }


}
