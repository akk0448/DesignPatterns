package rbs.model;

public class Experience {

    private String jobTitle;
    private String company;
    private String duration;
    private String responsibilities;

    public Experience() {
    }

    public Experience(String jobTitle, String company, String duration, String responsibilities) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.duration = duration;
        this.responsibilities = responsibilities;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Experience ---\n");
        sb.append(String.format("%-15s : %s%n", "Job Title", jobTitle));
        sb.append(String.format("%-15s : %s%n", "Company", company));
        sb.append(String.format("%-15s : %s%n", "Duration", duration));
        sb.append(String.format("%-15s : %s%n", "Responsibilities", responsibilities));
        return sb.toString();
    }
}