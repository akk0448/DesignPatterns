package pgs.gateway;

public class Stripe {

    public void makeStripePayment(double amountInRupees) {
        System.out.println("[Stripe] Charging ₹" + amountInRupees + " using Stripe...");
        System.out.println("✅ Stripe Payment Completed!");
    }
}
