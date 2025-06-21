package rbs.model;

public class PersonalInfo {

    private String fullName;
    private String email;
    private String phone;
    private String linkedIn;
    private String github;

    public PersonalInfo() {
    }

    public PersonalInfo(String fullName, String email, String phone, String linkedIn, String github) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.linkedIn = linkedIn;
        this.github = github;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Personal Information ---\n");
        sb.append(String.format("%-12s : %s%n", "Full Name", fullName));
        sb.append(String.format("%-12s : %s%n", "Email", email));
        sb.append(String.format("%-12s : %s%n", "Phone", phone));
        sb.append(String.format("%-12s : %s%n", "LinkedIn", linkedIn != null ? linkedIn : "N/A"));
        sb.append(String.format("%-12s : %s%n", "GitHub", github != null ? github : "N/A"));
        return sb.toString();
    }
}
