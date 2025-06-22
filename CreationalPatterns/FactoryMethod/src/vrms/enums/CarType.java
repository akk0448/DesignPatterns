package vrms.enums;

public enum CarType {

    HATCHBACK("Hatchback"),
    SEDAN("Sedan"),
    SUV("SUV");

    private final String displayName;

    CarType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
