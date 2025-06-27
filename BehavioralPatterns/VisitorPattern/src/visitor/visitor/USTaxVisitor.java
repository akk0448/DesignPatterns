package visitor.visitor;

import visitor.elements.Electronics;
import visitor.elements.Grocery;
import visitor.elements.LuxuryItem;

public class USTaxVisitor implements TaxVisitor {

    @Override
    public double visit(Grocery grocery) {
        return grocery.getPrice() * 0.05;
    }

    @Override
    public double visit(Electronics electronics) {
        return electronics.getPrice() * 0.08;
    }

    @Override
    public double visit(LuxuryItem luxuryItem) {
        return luxuryItem.getPrice() * 0.20;
    }
}