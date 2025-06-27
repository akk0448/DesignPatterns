package discount.startegy;

public class FlatDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double originalPrice) {
        return Math.max(0, originalPrice - 100);
    }
}