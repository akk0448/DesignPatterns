import cor.handler.*;
import cor.model.Request;

public class Main {
    public static void main(String[] args) {

        Handler authHandler = new AuthHandler();
        Handler validationHandler = new ValidationHandler();
        Handler businessLogicHandler = new BusinessLogicHandler();
        Handler loggingHandler = new LoggingHandler();

        authHandler.setNext(validationHandler)
                .setNext(businessLogicHandler)
                .setNext(loggingHandler);

        System.out.println("---- Test 1: Valid CREATE ----");
        Request createRequest = new Request("admin", "CREATE", "New product added");
        authHandler.handle(createRequest);

        System.out.println("\n---- Test 2: Valid UPDATE ----");
        Request updateRequest = new Request("admin", "UPDATE", "1:Updated product name");
        authHandler.handle(updateRequest);

        System.out.println("\n---- Test 3: Invalid DELETE (non-numeric ID) ----");
        Request invalidDeleteRequest = new Request("admin", "DELETE", "abc");
        authHandler.handle(invalidDeleteRequest);

        System.out.println("\n---- Test 4: Missing user (unauthenticated) ----");
        Request noUserRequest = new Request(null, "CREATE", "Should not work");
        authHandler.handle(noUserRequest);

        System.out.println("\n---- Test 5: Invalid action ----");
        Request invalidAction = new Request("admin", "INVALID", "Some data");
        authHandler.handle(invalidAction);
    }
}