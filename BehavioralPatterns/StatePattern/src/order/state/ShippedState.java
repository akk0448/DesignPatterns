package order.state;

import order.context.OrderContext;

public class ShippedState implements OrderState {

    public void next(OrderContext ctx) {
        ctx.setState(new DeliveredState());
    }

    public void cancel(OrderContext ctx) {
        ctx.setState(new CancelledState());
    }

    public void printStatus() {
        System.out.println("🚚 Order shipped. On the way!");
    }
}