import visitor.elements.Electronics;
import visitor.elements.Grocery;
import visitor.elements.LuxuryItem;
import visitor.model.Cart;
import visitor.visitor.IndiaTaxVisitor;
import visitor.visitor.USTaxVisitor;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new Grocery("Milk", 50));
        cart.addItem(new Electronics("Headphones", 2000));
        cart.addItem(new LuxuryItem("Watch", 10000));

        System.out.println("\n--- India Tax Calculation ---");
        double indiaTax = cart.calculateTotalTax(new IndiaTaxVisitor());
        System.out.printf("Total Tax (India): ₹%.2f\n", indiaTax);

        System.out.println("\n--- USA Tax Calculation ---");
        double usaTax = cart.calculateTotalTax(new USTaxVisitor());
        System.out.printf("Total Tax (USA): ₹%.2f\n", usaTax);
    }
}