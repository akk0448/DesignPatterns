package discount.startegy;

public class NewUserDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.80;
    }
}
