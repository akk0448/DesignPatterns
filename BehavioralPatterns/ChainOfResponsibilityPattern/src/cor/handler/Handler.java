package cor.handler;

import cor.model.Request;

public interface Handler {

    Handler setNext(Handler next);

    void handle(Request request);
}
