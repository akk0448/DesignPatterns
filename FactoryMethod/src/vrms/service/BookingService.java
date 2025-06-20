package vrms.service;

import vrms.model.Booking;
import vrms.model.Vehicle;
import vrms.enums.VehicleType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Scanner;
import java.util.UUID;

public class BookingService {

    private final Scanner scanner;

    public BookingService() {
        this.scanner = new Scanner(System.in);
    }

    public Booking createBooking(Vehicle vehicle, VehicleType vehicleType) {
        System.out.print("\nEnter number of days to rent: ");
        int days = readValidDays();

        BigDecimal totalCost = vehicle.calculateRentalPrice(days);
        String bookingId = generateBookingId();
        long bookingTime = Instant.now().toEpochMilli();

        Booking booking = new Booking(bookingId, vehicleType, days, totalCost, bookingTime);

        System.out.println("\nBooking created successfully!");
        System.out.println(booking);

        return booking;
    }

    private int readValidDays() {
        int days = -1;
        while (days <= 0) {
            if (scanner.hasNextInt()) {
                days = scanner.nextInt();
                if (days <= 0) {
                    System.out.print("Days must be greater than 0. Please enter again: ");
                }
            } else {
                scanner.next(); // discard invalid input
                System.out.print("Invalid input. Please enter a valid number of days: ");
            }
        }
        return days;
    }

    private String generateBookingId() {
        return "BK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}

