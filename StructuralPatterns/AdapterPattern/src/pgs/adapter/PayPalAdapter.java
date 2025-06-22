package pgs.adapter;

import pgs.gateway.PayPal;
import pgs.processor.PaymentProcessor;

public class PayPalAdapter implements PaymentProcessor {

    private final PayPal payPal;

    public PayPalAdapter() {
        this.payPal = new PayPal();
    }

    @Override
    public void pay(double amount) {
        payPal.sendPayment(amount);
    }
}
