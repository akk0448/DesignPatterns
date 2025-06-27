package visitor.elements;

import visitor.visitor.TaxVisitor;

public interface Item {

    String getName();

    double getPrice();

    double accept(TaxVisitor visitor);
}