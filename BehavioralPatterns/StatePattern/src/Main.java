import order.context.OrderContext;

public class Main {
    public static void main(String[] args) {
        OrderContext order = new OrderContext();

        order.printStatus(); // Ordered
        order.nextState();   // Ship it
        order.printStatus(); // Shipped
        order.nextState();   // Deliver it
        order.printStatus(); // Delivered

        order.cancelOrder(); // Too late to cancel
        order.nextState();   // Already delivered
    }
}