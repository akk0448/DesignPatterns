import discount.context.PriceCalculator;
import discount.startegy.FestivalDiscount;
import discount.startegy.FlatDiscount;
import discount.startegy.NewUserDiscount;

public class Main {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        double price = 1200;

        calculator.setStrategy(new NewUserDiscount());
        System.out.println("New User Price: ₹" + calculator.calculate(price));

        calculator.setStrategy(new FestivalDiscount());
        System.out.println("Festival Price: ₹" + calculator.calculate(price));

        calculator.setStrategy(new FlatDiscount());
        System.out.println("Flat Discount Price: ₹" + calculator.calculate(price));
    }
}