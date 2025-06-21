import rbs.builder.Resume;
import rbs.model.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PersonalInfo personalInfo = new PersonalInfo(
                "Aniket Kumar",
                "aniket@example.com",
                "+91-9876543210",
                "linkedin.com/in/aniket",
                "github.com/aniket"
        );

        Education edu1 = new Education("B.Tech in CSE", "ABC University", "2023", 8.75);
        Education edu2 = new Education("12th Grade", "XYZ School", "2019", 9.1);

        Experience exp1 = new Experience("Backend Developer", "Tech Corp", "Jan 2023 - Present", "Developed REST APIs and improved performance.");

        Skill s1 = Skill.builder()
                .withName("Java")
                .withLevel("Advanced")
                .build();
        Skill s2 = Skill.builder()
                .withName("Spring Boot")
                .withLevel("Intermediate")
                .build();
        Skill s3 = Skill.builder()
                .withName("SQL")
                .withLevel("Intermediate")
                .build();

        Project p1 = Project.builder()
                .title("Vehicle Rental System")
                .description("Built a console-based app using Factory Method.")
                .technologies("Java, OOP")
                .build();

        Project p2 = Project.builder()
                .title("Resume Builder System")
                .description("Implemented resume builder using Builder Pattern.")
                .technologies("Java, Design Patterns")
                .build();

        List<String> certifications = List.of(
                "Oracle Certified Java Programmer",
                "AWS Cloud Practitioner"
        );

        String summary = "Enthusiastic backend developer with a strong grasp of Java, Spring Boot, and design patterns. Passionate about building clean and maintainable code.";

        Resume resume = new Resume.ResumeBuilder()
                .withPersonalInfo(personalInfo)
                .withEducation(List.of(edu1, edu2))
                .withExperience(List.of(exp1))
                .withSkills(List.of(s1, s2, s3))
                .withProjects(List.of(p1, p2))
                .withCertifications(certifications)
                .withSummary(summary)
                .build();

        resume.printResume();
    }
}