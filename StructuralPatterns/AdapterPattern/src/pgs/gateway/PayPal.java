package pgs.gateway;

public class PayPal {

    public void sendPayment(double amount) {
        System.out.println("[PayPal] Sending Rs. " + amount + " via PayPal API...");
        System.out.println("✅ PayPal Payment Successful!");
    }
}
