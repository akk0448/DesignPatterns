package dtms.model;

import static dtms.utils.DateTimeUtils.millisToDateTime;

public class Resume implements Document {

    private final String title;
    private final String name;
    private final String email;
    private final String content;
    private final Long createdAt;

    private Resume(ResumeBuilder builder) {
        this.title = builder.title;
        this.name = builder.name;
        this.email = builder.email;
        this.content = builder.content;
        this.createdAt = System.currentTimeMillis();
    }

    public static ResumeBuilder builder() {
        return new ResumeBuilder();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public Document cloneDocument() {
        return Resume.builder()
                .withTitle(this.title)
                .withName(this.name)
                .withEmail(this.email)
                .withContent(this.content)
                .build();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Resume ---\n");
        sb.append(String.format("%-14s : %s%n", "Title", title));
        sb.append(String.format("%-14s : %s%n", "Name", name));
        sb.append(String.format("%-14s : %s%n", "Email", email));
        sb.append(String.format("%-14s : %s%n", "Content", content));
        sb.append(String.format("%-14s : %s%n", "Created At", millisToDateTime(createdAt)));
        sb.append("------------------------\n");
        return sb.toString();
    }

    public static class ResumeBuilder {
        private String title;
        private String name;
        private String email;
        private String content;

        public ResumeBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ResumeBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ResumeBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ResumeBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public Resume build() {
            if (title == null || title.isBlank()) {
                throw new IllegalStateException("Resume must have a title.");
            }
            if (name == null || name.isBlank()) {
                throw new IllegalStateException("Resume must have a name.");
            }
            if (email == null || email.isBlank()) {
                throw new IllegalStateException("Resume must have an email.");
            }
            if (content == null || content.isBlank()) {
                throw new IllegalStateException("Resume must have content.");
            }
            return new Resume(this);
        }
    }
}