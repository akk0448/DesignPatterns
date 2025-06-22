package rbs.model;

public class Project {

    private final String title;
    private final String description;
    private final String technologies;

    private Project(ProjectBuilder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.technologies = builder.technologies;
    }

    public static ProjectBuilder builder() {
        return new ProjectBuilder();
    }

    public static class ProjectBuilder {
        private String title;
        private String description;
        private String technologies;

        public ProjectBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProjectBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProjectBuilder technologies(String technologies) {
            this.technologies = technologies;
            return this;
        }

        public Project build() {
            if (title == null || title.isBlank()) {
                throw new IllegalStateException("Project title is required.");
            }
            return new Project(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Project ---\n");
        sb.append(String.format("%-14s : %s%n", "Title", title));
        sb.append(String.format("%-14s : %s%n", "Description", description != null ? description : "N/A"));
        sb.append(String.format("%-14s : %s%n", "Technologies", technologies != null ? technologies : "N/A"));
        return sb.toString();
    }
}