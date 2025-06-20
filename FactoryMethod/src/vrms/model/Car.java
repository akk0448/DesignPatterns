package vrms.model;

import vrms.enums.CarType;
import vrms.enums.FuelType;

import java.math.BigDecimal;

import static vrms.utils.ApplicationUtils.formatAmount;

public class Car implements Vehicle {

    private String id;
    private String name;
    private CarType carType;
    private FuelType fuelType;
    private Integer seatingCapacity;
    private BigDecimal dailyRate;

    public Car() {
    }

    public Car(String id, String name, CarType carType, FuelType fuelType, Integer seatingCapacity, BigDecimal dailyRate) {
        this.id = id;
        this.name = name;
        this.carType = carType;
        this.fuelType = fuelType;
        this.seatingCapacity = seatingCapacity;
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

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
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
        sb.append("\n--- Car Details ---\n");
        sb.append("ID                    : ").append(id).append("\n");
        sb.append("Name                  : ").append(name).append("\n");
        sb.append("Type                  : ").append(carType.getDisplayName()).append("\n");
        sb.append("Fuel Type             : ").append(fuelType.getDisplayName()).append("\n");
        sb.append("Seating Capacity      : ").append(seatingCapacity).append("\n");
        sb.append("Daily Rate            : ").append(formatAmount(dailyRate)).append("\n");
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
