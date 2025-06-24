package cor.handler;

import cor.model.Request;

public class AuthHandler extends AbstractHandler {

    @Override
    public void handle(Request request) {
        if (request.getUser() == null || request.getUser().isBlank()) {
            System.out.println("AuthHandler: Unauthorized request. No user found.");
            return;
        }

        System.out.println("AuthHandler: User authenticated - " + request.getUser());
        super.handle(request);
    }
}