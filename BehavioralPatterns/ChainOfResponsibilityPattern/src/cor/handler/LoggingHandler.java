package cor.handler;

import cor.model.Request;

public class LoggingHandler extends AbstractHandler {

    @Override
    public void handle(Request request) {
        System.out.println("LoggingHandler: Logging request -> User: "
                + request.getUser() + ", Action: " + request.getAction() + ", Payload: " + request.getPayload());

        super.handle(request);
    }
}