package pgs.gateway;

public class Razorpay {

    public void processPayment(double amount) {
        System.out.println("[Razorpay] Processing payment of ₹" + amount + " through Razorpay gateway...");
        System.out.println("✅ Razorpay Payment Done!");
    }
}
