import vrms.enums.VehicleType;
import vrms.factory.VehicleFactory;
import vrms.model.Booking;
import vrms.model.Vehicle;
import vrms.provider.VehicleFactoryProvider;
import vrms.service.BookingService;
import vrms.utils.ConsoleInputUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Welcome to Vehicle Rental Management System ===");

        List<Booking> bookingHistory = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Make a Booking");
            System.out.println("2. View Booking History");
            System.out.println("3. Exit");

            int choice = ConsoleInputUtils.readIntInRange(1, 3, "Enter your choice (1-3): ");

            switch (choice) {
                case 1 -> {
                    VehicleType vehicleType = ConsoleInputUtils.promptVehicleType();
                    VehicleFactory factory = VehicleFactoryProvider.getFactory(vehicleType);
                    Vehicle vehicle = factory.createVehicle();

                    BookingService bookingService = new BookingService();
                    Booking booking = bookingService.createBooking(vehicle, vehicleType);

                    bookingHistory.add(booking);
                }
                case 2 -> {
                    if (bookingHistory.isEmpty()) {
                        System.out.println("\nNo bookings found.");
                    } else {
                        System.out.println("\n=== Booking History ===");
                        for (Booking booking : bookingHistory) {
                            System.out.println(booking);
                        }
                    }
                }
                case 3 -> {
                    exit = true;
                    System.out.println("\nThank you for using the Vehicle Rental System. Goodbye!");
                }
            }
        }
    }
}