package rbs.builder;

import rbs.model.*;

import java.util.List;

public class Resume {

    private final PersonalInfo personalInfo;
    private final List<Education> educationList;
    private final List<Experience> experienceList;
    private final List<Skill> skillList;
    private final List<Project> projectList;
    private final List<String> certifications;
    private final String summary;

    private Resume(ResumeBuilder builder) {
        this.personalInfo = builder.personalInfo;
        this.educationList = builder.educationList;
        this.experienceList = builder.experienceList;
        this.skillList = builder.skillList;
        this.projectList = builder.projectList;
        this.certifications = builder.certifications;
        this.summary = builder.summary;
    }

    public static ResumeBuilder builder() {
        return new ResumeBuilder();
    }

    public void printResume() {
        System.out.println("====================================");
        System.out.println("             RESUME                 ");
        System.out.println("====================================");

        System.out.println(personalInfo);

        if (summary != null && !summary.isBlank()) {
            System.out.println("\n--- Summary ---");
            System.out.println(summary);
        }

        if (educationList != null && !educationList.isEmpty()) {
            System.out.println("\n=== Education ===");
            for (Education edu : educationList) {
                System.out.println(edu);
            }
        }

        if (experienceList != null && !experienceList.isEmpty()) {
            System.out.println("\n=== Experience ===");
            for (Experience exp : experienceList) {
                System.out.println(exp);
            }
        }

        if (skillList != null && !skillList.isEmpty()) {
            System.out.println("\n=== Skills ===");
            for (Skill skill : skillList) {
                System.out.println(skill);
            }
        }

        if (projectList != null && !projectList.isEmpty()) {
            System.out.println("\n=== Projects ===");
            for (Project project : projectList) {
                System.out.println(project);
            }
        }

        if (certifications != null && !certifications.isEmpty()) {
            System.out.println("\n=== Certifications ===");
            for (String cert : certifications) {
                System.out.println("- " + cert);
            }
        }

        System.out.println("====================================\n");
    }


    public static class ResumeBuilder {
        private PersonalInfo personalInfo;
        private List<Education> educationList;
        private List<Experience> experienceList;
        private List<Skill> skillList;
        private List<Project> projectList;
        private List<String> certifications;
        private String summary;

        public ResumeBuilder withPersonalInfo(PersonalInfo info) {
            this.personalInfo = info;
            return this;
        }

        public ResumeBuilder withEducation(List<Education> educationList) {
            this.educationList = educationList;
            return this;
        }

        public ResumeBuilder withExperience(List<Experience> experienceList) {
            this.experienceList = experienceList;
            return this;
        }

        public ResumeBuilder withSkills(List<Skill> skillList) {
            this.skillList = skillList;
            return this;
        }

        public ResumeBuilder withProjects(List<Project> projectList) {
            this.projectList = projectList;
            return this;
        }

        public ResumeBuilder withCertifications(List<String> certifications) {
            this.certifications = certifications;
            return this;
        }

        public ResumeBuilder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Resume build() {
            if (personalInfo == null || educationList == null) {
                throw new IllegalStateException("Personal Info and Education are required.");
            }
            return new Resume(this);
        }
    }
}