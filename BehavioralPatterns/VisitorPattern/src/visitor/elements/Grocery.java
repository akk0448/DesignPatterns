package visitor.elements;

import visitor.visitor.TaxVisitor;

public class Grocery implements Item {
    private final String name;
    private final double price;

    public Grocery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double accept(TaxVisitor visitor) {
        return visitor.visit(this);
    }
}