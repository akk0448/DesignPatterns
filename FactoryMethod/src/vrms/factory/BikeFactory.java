package vrms.factory;

import vrms.enums.BikeType;
import vrms.model.Bike;
import vrms.model.Vehicle;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BikeFactory implements VehicleFactory {

    private static final Map<BikeType, List<Bike>> availableBikes = new HashMap<>();

    static {
        availableBikes.put(BikeType.CRUISER, List.of(
                new Bike("B001", "Royal Enfield Classic 350", BikeType.CRUISER, 346, true, new BigDecimal("500")),
                new Bike("B002", "Jawa 42", BikeType.CRUISER, 293, true, new BigDecimal("550"))
        ));

        availableBikes.put(BikeType.SPORTS, List.of(
                new Bike("B003", "Yamaha R15", BikeType.SPORTS, 155, true, new BigDecimal("600")),
                new Bike("B004", "KTM RC 200", BikeType.SPORTS, 199, true, new BigDecimal("650"))
        ));

        availableBikes.put(BikeType.ELECTRIC, List.of(
                new Bike("B005", "Ather 450X", BikeType.ELECTRIC, 0, false, new BigDecimal("300")),
                new Bike("B006", "Ola S1 Pro", BikeType.ELECTRIC, 0, false, new BigDecimal("280"))
        ));
    }


    @Override
    public Vehicle createVehicle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Bike Type:");
        BikeType[] types = BikeType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.printf("%d. %s%n", i + 1, types[i].getDisplayName());
        }

        int typeChoice = -1;
        while (typeChoice < 1 || typeChoice > types.length) {
            System.out.print("Enter choice (1-" + types.length + "): ");
            if (scanner.hasNextInt()) {
                typeChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        BikeType selectedType = types[typeChoice - 1];
        List<Bike> bikes = availableBikes.get(selectedType);

        System.out.printf("%nAvailable %s Bikes:%n", selectedType.getDisplayName());
        for (int i = 0; i < bikes.size(); i++) {
            System.out.printf("%d. %s (%dcc)%n", i + 1, bikes.get(i).getName(), bikes.get(i).getEngineCC());
        }

        int bikeChoice = -1;
        while (bikeChoice < 1 || bikeChoice > bikes.size()) {
            System.out.print("Enter bike choice (1-" + bikes.size() + "): ");
            if (scanner.hasNextInt()) {
                bikeChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        Bike selectedBike = bikes.get(bikeChoice - 1);

        System.out.println("\nYou have selected:");
        selectedBike.displayInfo();

        return selectedBike;
    }

}
