package vrms.enums;

public enum BikeType {

    CRUISER("Cruiser"),
    SPORTS("Sports"),
    ELECTRIC("Electric");

    private final String displayName;

    BikeType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
