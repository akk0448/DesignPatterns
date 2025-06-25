package order.state;

import order.context.OrderContext;

public class OrderedState implements OrderState {

    public void next(OrderContext ctx) {
        ctx.setState(new ShippedState());
    }

    public void cancel(OrderContext ctx) {
        ctx.setState(new CancelledState());
    }

    public void printStatus() {
        System.out.println("🛒 Order placed. Waiting to be shipped.");
    }
}