package bams.enums;

public enum ClientType {

    INDIVIDUAL("Individual"),
    BUSINESS("Business");

    private final String displayName;

    ClientType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
