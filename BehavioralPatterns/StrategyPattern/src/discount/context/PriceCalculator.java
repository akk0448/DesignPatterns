package discount.context;

import discount.startegy.DiscountStrategy;

public class PriceCalculator {

    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double price) {
        if (strategy == null) {
            throw new IllegalStateException("Discount strategy not set.");
        }
        return strategy.applyDiscount(price);
    }
}