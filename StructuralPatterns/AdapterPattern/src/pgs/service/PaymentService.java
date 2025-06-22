package pgs.service;

import pgs.processor.PaymentProcessor;

public class PaymentService {

    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void processPayment(double amount) {
        System.out.println("Initiating payment of ₹" + amount + "...");
        paymentProcessor.pay(amount);
    }
}
