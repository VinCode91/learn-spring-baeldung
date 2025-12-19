package com.baeldung.ls.events;

public class ProjectCreatedEvent {

    protected final Long projectId;

    public ProjectCreatedEvent(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public static class NewProjectDetails extends ProjectCreatedEvent {
        private final String name;

        public NewProjectDetails(Long id, String name) {
            super(id);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
