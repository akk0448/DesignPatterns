package vrms.utils;

import vrms.enums.VehicleType;

import java.util.Scanner;

public class ConsoleInputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readIntInRange(int min, int max, String prompt) {
        int value = -1;
        while (value < min || value > max) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
            } else {
                scanner.next();
            }
        }
        return value;
    }

    public static VehicleType promptVehicleType() {
        System.out.println("What would you like to rent?");
        VehicleType[] types = VehicleType.values();

        for (int i = 0; i < types.length; i++) {
            System.out.printf("%d. %s%n", i + 1, types[i].getDisplayName());
        }

        int choice = readIntInRange(1, types.length, "Enter your choice (1-" + types.length + "): ");
        return types[choice - 1];
    }

    public static int promptRentalDays() {
        return readIntInRange(1, 365, "Enter number of rental days: ");
    }

    public static Scanner getScanner() {
        return scanner;
    }
}