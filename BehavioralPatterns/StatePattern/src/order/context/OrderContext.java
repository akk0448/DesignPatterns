package order.context;

import order.state.OrderState;
import order.state.OrderedState;

public class OrderContext {

    private OrderState currentState;

    public OrderContext() {
        this.currentState = new OrderedState();
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public void nextState() {
        currentState.next(this);
    }

    public void cancelOrder() {
        currentState.cancel(this);
    }

    public void printStatus() {
        currentState.printStatus();
    }
}