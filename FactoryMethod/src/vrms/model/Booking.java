package vrms.model;

import vrms.enums.VehicleType;

import java.math.BigDecimal;

import static vrms.utils.ApplicationUtils.formatAmount;
import static vrms.utils.DateTimeUtils.millisToDateTime;

public class Booking {

    private String bookingId;
    private VehicleType vehicleType;
    private Integer days;
    private BigDecimal totalCost;
    private Long bookingTime;

    public Booking() {
    }

    public Booking(String bookingId, VehicleType vehicleType, Integer days, BigDecimal totalCost, Long bookingTime) {
        this.bookingId = bookingId;
        this.vehicleType = vehicleType;
        this.days = days;
        this.totalCost = totalCost;
        this.bookingTime = bookingTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Long getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Long bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Booking Summary ---\n");
        sb.append("Booking ID    : ").append(bookingId).append("\n");
        sb.append("Vehicle Type  : ").append(vehicleType.getDisplayName()).append("\n");
        sb.append("Days Rented   : ").append(days).append("\n");
        sb.append("Total Cost    : ").append(formatAmount(totalCost)).append("\n");
        sb.append("Booked At     : ").append(millisToDateTime(bookingTime)).append("\n");
        sb.append("------------------------\n");
        return sb.toString();
    }
}