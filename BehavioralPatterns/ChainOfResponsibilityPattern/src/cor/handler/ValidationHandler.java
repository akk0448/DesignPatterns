package cor.handler;


import cor.model.Request;

import java.util.Arrays;
import java.util.List;

public class ValidationHandler extends AbstractHandler {

    private static final List<String> ALLOWED_ACTIONS = Arrays.asList("CREATE", "UPDATE", "DELETE");

    @Override
    public void handle(Request request) {
        if (request.getAction() == null || !ALLOWED_ACTIONS.contains(request.getAction().toUpperCase())) {
            System.out.println("ValidationHandler: Invalid or missing action.");
            return;
        }

        if (request.getPayload() == null || request.getPayload().isBlank()) {
            System.out.println("ValidationHandler: Payload is missing.");
            return;
        }

        System.out.println("ValidationHandler: Request is valid.");
        super.handle(request);
    }
}