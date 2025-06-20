package vrms.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class ApplicationUtils {

    public static String formatAmount(BigDecimal totalCost) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        return totalCost != null ? currencyFormat.format(totalCost) : "N/A";
    }
}
