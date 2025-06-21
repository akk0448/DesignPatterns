package rbs.model;

public class Education {

    private String degree;
    private String university;
    private String graduationYear;
    private double cgpa;

    public Education() {
    }

    public Education(String degree, String university, String graduationYear, double cgpa) {
        this.degree = degree;
        this.university = university;
        this.graduationYear = graduationYear;
        this.cgpa = cgpa;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Education ---\n");
        sb.append(String.format("%-15s : %s%n", "Degree", degree));
        sb.append(String.format("%-15s : %s%n", "University", university));
        sb.append(String.format("%-15s : %s%n", "Graduation Year", graduationYear));
        sb.append(String.format("%-15s : %.2f%n", "CGPA", cgpa));
        return sb.toString();
    }
}