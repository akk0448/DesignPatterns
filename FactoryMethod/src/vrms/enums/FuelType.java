package vrms.enums;

public enum FuelType {

    PETROL("Petrol"),
    DIESEL("Diesel"),
    ELECTRIC("Electric"),
    CNG("CNG");

    private final String displayName;

    FuelType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
