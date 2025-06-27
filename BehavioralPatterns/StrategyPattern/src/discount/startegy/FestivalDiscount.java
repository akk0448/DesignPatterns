package discount.startegy;

public class FestivalDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double originalPrice) {
        if (originalPrice > 1000) {
            return originalPrice * 0.85;
        }
        return originalPrice;
    }
}