package vrms.model;

import java.math.BigDecimal;

public interface Vehicle {

    void displayInfo();

    BigDecimal calculateRentalPrice(int days);
}
