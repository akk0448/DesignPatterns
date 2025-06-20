package vrms.factory;

import vrms.enums.CarType;
import vrms.enums.FuelType;
import vrms.model.Car;
import vrms.model.Vehicle;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarFactory implements VehicleFactory {

    private static final Map<CarType, List<Car>> availableCars = new HashMap<>();

    static {
        availableCars.put(CarType.SEDAN, List.of(
                new Car("C001", "Honda City", CarType.SEDAN, FuelType.PETROL, 5, new BigDecimal("1200")),
                new Car("C002", "Hyundai Verna", CarType.SEDAN, FuelType.DIESEL, 5, new BigDecimal("1300"))
        ));

        availableCars.put(CarType.SUV, List.of(
                new Car("C003", "Tata Harrier", CarType.SUV, FuelType.DIESEL, 5, new BigDecimal("1600")),
                new Car("C004", "Hyundai Creta", CarType.SUV, FuelType.PETROL, 5, new BigDecimal("1550"))
        ));

        availableCars.put(CarType.HATCHBACK, List.of(
                new Car("C005", "Maruti Swift", CarType.HATCHBACK, FuelType.PETROL, 5, new BigDecimal("900")),
                new Car("C006", "Tata Tiago EV", CarType.HATCHBACK, FuelType.ELECTRIC, 5, new BigDecimal("1000"))
        ));
    }


    @Override
    public Vehicle createVehicle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Car Type:");
        CarType[] carTypes = CarType.values();
        for (int i = 0; i < carTypes.length; i++) {
            System.out.printf("%d. %s%n", i + 1, carTypes[i].getDisplayName());
        }

        int carTypeChoice = -1;
        while (carTypeChoice < 1 || carTypeChoice > carTypes.length) {
            System.out.print("Enter choice (1-" + carTypes.length + "): ");
            if (scanner.hasNextInt()) {
                carTypeChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        CarType selectedCarType = carTypes[carTypeChoice - 1];

        System.out.println("\nSelect Fuel Type:");
        FuelType[] fuelTypes = FuelType.values();
        for (int i = 0; i < fuelTypes.length; i++) {
            System.out.printf("%d. %s%n", i + 1, fuelTypes[i].getDisplayName());
        }

        int fuelTypeChoice = -1;
        while (fuelTypeChoice < 1 || fuelTypeChoice > fuelTypes.length) {
            System.out.print("Enter choice (1-" + fuelTypes.length + "): ");
            if (scanner.hasNextInt()) {
                fuelTypeChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        FuelType selectedFuelType = fuelTypes[fuelTypeChoice - 1];

        List<Car> cars = availableCars.getOrDefault(selectedCarType, List.of()).stream()
                .filter(c -> c.getFuelType() == selectedFuelType)
                .toList();

        if (cars.isEmpty()) {
            System.out.println("\nNo cars available for selected type and fuel. Try again.");
            return createVehicle();
        }

        System.out.printf("%nAvailable %s Cars (%s):%n", selectedCarType.getDisplayName(), selectedFuelType.getDisplayName());
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.printf("%d. %s (%d seats)%n", i + 1, car.getName(), car.getSeatingCapacity());
        }

        int carChoice = -1;
        while (carChoice < 1 || carChoice > cars.size()) {
            System.out.print("Enter car choice (1-" + cars.size() + "): ");
            if (scanner.hasNextInt()) {
                carChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        Car selectedCar = cars.get(carChoice - 1);

        System.out.println("\nYou have selected:");
        selectedCar.displayInfo();

        return selectedCar;
    }

}
