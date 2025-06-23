package ecs.service;

public class PaymentService {

    public boolean processPayment(double amount) {
        System.out.printf("Processing payment of ₹%.2f...\n", amount);
        return true;
    }
}