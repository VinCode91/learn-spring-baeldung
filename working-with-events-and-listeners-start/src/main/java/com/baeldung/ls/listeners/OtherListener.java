package com.baeldung.ls.listeners;

import com.baeldung.ls.events.ProjectCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OtherListener {

    private static Logger LOG = LoggerFactory.getLogger(ProjectCreatedEventListener.class);

    @EventListener
    public void handleProjectCreatedEvent(ProjectCreatedEvent event) {
        LOG.info("Other listener logic for new Project Created with Id {}", event.getProjectId());
    }

    @EventListener
    public void handleNewProjectDetailsEvent(ProjectCreatedEvent.NewProjectDetails event) {
        LOG.info("Other listener handle new project {} details: name is {}", event.getProjectId(), event.getName());
    }
}
