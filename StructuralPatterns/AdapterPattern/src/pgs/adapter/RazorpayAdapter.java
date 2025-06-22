package pgs.adapter;

import pgs.gateway.Razorpay;
import pgs.processor.PaymentProcessor;

public class RazorpayAdapter implements PaymentProcessor {

    private final Razorpay razorpay;

    public RazorpayAdapter() {
        this.razorpay = new Razorpay();
    }

    @Override
    public void pay(double amount) {
        razorpay.processPayment(amount);
    }
}
