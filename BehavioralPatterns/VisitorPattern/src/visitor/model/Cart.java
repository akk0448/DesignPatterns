package visitor.model;

import visitor.elements.Item;
import visitor.visitor.TaxVisitor;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotalTax(TaxVisitor visitor) {
        double totalTax = 0;
        for (Item item : items) {
            double tax = item.accept(visitor);
            System.out.printf("%-15s Tax: ₹%.2f\n", item.getName(), tax);
            totalTax += tax;
        }
        return totalTax;
    }
}