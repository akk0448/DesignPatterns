package visitor.visitor;

import visitor.elements.Electronics;
import visitor.elements.Grocery;
import visitor.elements.LuxuryItem;

public interface TaxVisitor {

    double visit(Grocery grocery);

    double visit(Electronics electronics);

    double visit(LuxuryItem luxuryItem);
}
