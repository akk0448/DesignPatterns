package pgs.adapter;

import pgs.gateway.Stripe;
import pgs.processor.PaymentProcessor;

public class StripeAdapter implements PaymentProcessor {

    private final Stripe stripe;

    public StripeAdapter() {
        this.stripe = new Stripe();
    }

    @Override
    public void pay(double amount) {
        stripe.makeStripePayment(amount);
    }
}
