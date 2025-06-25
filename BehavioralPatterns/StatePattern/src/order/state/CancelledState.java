package order.state;

import order.context.OrderContext;

public class CancelledState implements OrderState {

    public void next(OrderContext ctx) {
        System.out.println("⚠️ Cannot proceed. Order was cancelled.");
    }

    public void cancel(OrderContext ctx) {
        System.out.println("⚠️ Order already cancelled.");
    }

    public void printStatus() {
        System.out.println("🚫 Order has been cancelled.");
    }
}