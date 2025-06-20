package vrms.model;

import vrms.enums.BikeType;

import java.math.BigDecimal;

import static vrms.utils.ApplicationUtils.formatAmount;

public class Bike implements Vehicle {

    private String id;
    private String name;
    private BikeType bikeType;
    private Integer engineCC;
    private Boolean isGeared;
    private BigDecimal dailyRate;

    public Bike() {
    }

    public Bike(String id, String name, BikeType bikeType, Integer engineCC, Boolean isGeared, BigDecimal dailyRate) {
        this.id = id;
        this.name = name;
        this.bikeType = bikeType;
        this.engineCC = engineCC;
        this.isGeared = isGeared;
        this.dailyRate = dailyRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }

    public Integer getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(Integer engineCC) {
        this.engineCC = engineCC;
    }

    public Boolean getGeared() {
        return isGeared;
    }

    public void setGeared(Boolean geared) {
        isGeared = geared;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Bike Details ---\n");
        sb.append("ID          : ").append(id).append("\n");
        sb.append("Name        : ").append(name).append("\n");
        sb.append("Type        : ").append(bikeType.getDisplayName()).append("\n");
        sb.append("Engine CC   : ").append(engineCC).append(" cc\n");
        sb.append("Geared      : ").append(isGeared ? "Yes" : "No").append("\n");
        sb.append("Daily Rate  : ").append(formatAmount(dailyRate)).append("\n");
        sb.append("--------------------\n");
        return sb.toString();
    }

    @Override
    public void displayInfo() {
        System.out.println(this);
    }

    @Override
    public BigDecimal calculateRentalPrice(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Booking days should be greater than 0");
        }
        return dailyRate.multiply(BigDecimal.valueOf(days));
    }
}
