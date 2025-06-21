package dtms.model;

import static dtms.utils.DateTimeUtils.millisToDateTime;

public class Report implements Document {

    private final String title;
    private final String author;
    private final String content;
    private final String department;
    private final Long createdAt;

    private Report(ReportBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.content = builder.content;
        this.department = builder.department;
        this.createdAt = System.currentTimeMillis();
    }

    public static ReportBuilder builder() {
        return new ReportBuilder();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public Document cloneDocument() {
        return Report.builder()
                .withTitle(this.title)
                .withAuthor(this.author)
                .withContent(this.content)
                .withDepartment(this.department)
                .build();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Report ---\n");
        sb.append(String.format("%-14s : %s%n", "Title", title));
        sb.append(String.format("%-14s : %s%n", "Author", author));
        sb.append(String.format("%-14s : %s%n", "Department", department));
        sb.append(String.format("%-14s : %s%n", "Content", content));
        sb.append(String.format("%-14s : %s%n", "Created At", millisToDateTime(createdAt)));
        sb.append("------------------------\n");
        return sb.toString();
    }

    public static class ReportBuilder {
        private String title;
        private String author;
        private String content;
        private String department;

        public ReportBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ReportBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public ReportBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public ReportBuilder withDepartment(String department) {
            this.department = department;
            return this;
        }

        public Report build() {
            if (title == null || title.isBlank()) {
                throw new IllegalStateException("Report must have a title.");
            }
            if (author == null || author.isBlank()) {
                throw new IllegalStateException("Report must have an author.");
            }
            if (department == null || department.isBlank()) {
                throw new IllegalStateException("Report must have a department.");
            }
            if (content == null || content.isBlank()) {
                throw new IllegalStateException("Report must have content.");
            }
            return new Report(this);
        }
    }
}