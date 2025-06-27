package visitor.visitor;

import visitor.elements.Electronics;
import visitor.elements.Grocery;
import visitor.elements.LuxuryItem;

public class IndiaTaxVisitor implements TaxVisitor {

    @Override
    public double visit(Grocery grocery) {
        return 0;
    }

    @Override
    public double visit(Electronics electronics) {
        return electronics.getPrice() * 0.18;
    }

    @Override
    public double visit(LuxuryItem luxuryItem) {
        return luxuryItem.getPrice() * 0.28;
    }
}