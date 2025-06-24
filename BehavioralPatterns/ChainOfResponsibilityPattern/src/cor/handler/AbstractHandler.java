package cor.handler;

import cor.model.Request;

public abstract class AbstractHandler implements Handler {

    private Handler next;

    @Override
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    @Override
    public void handle(Request request) {
        if (next != null) {
            next.handle(request);
        }
    }
}