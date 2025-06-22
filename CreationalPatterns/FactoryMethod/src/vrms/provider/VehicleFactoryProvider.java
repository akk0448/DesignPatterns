package vrms.provider;

import vrms.enums.VehicleType;
import vrms.factory.BikeFactory;
import vrms.factory.CarFactory;
import vrms.factory.VehicleFactory;

public class VehicleFactoryProvider {

    public static VehicleFactory getFactory(VehicleType type) {
        return switch (type) {
            case BIKE -> new BikeFactory();
            case CAR -> new CarFactory();
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }
}

