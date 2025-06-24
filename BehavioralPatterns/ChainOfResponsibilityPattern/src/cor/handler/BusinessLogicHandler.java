package cor.handler;

import cor.model.Request;

import java.util.HashMap;
import java.util.Map;

public class BusinessLogicHandler extends AbstractHandler {

    private static int idCounter = 1;
    private final Map<Integer, String> database = new HashMap<>();

    @Override
    public void handle(Request request) {
        String action = request.getAction().toUpperCase();
        String payload = request.getPayload();

        switch (action) {
            case "CREATE":
                int id = idCounter++;
                database.put(id, payload);
                System.out.println("BusinessLogicHandler: Created entry with ID " + id + " and payload \"" + payload + "\"");
                break;

            case "UPDATE":
                String[] parts = payload.split(":", 2);
                if (parts.length != 2) {
                    System.out.println("BusinessLogicHandler: Invalid update payload format. Use 'id:value'");
                    return;
                }
                try {
                    int updateId = Integer.parseInt(parts[0].trim());
                    if (!database.containsKey(updateId)) {
                        System.out.println("BusinessLogicHandler: No record with ID " + updateId);
                        return;
                    }
                    database.put(updateId, parts[1].trim());
                    System.out.println("BusinessLogicHandler: Updated record with ID " + updateId);
                } catch (NumberFormatException e) {
                    System.out.println("BusinessLogicHandler: Invalid ID format.");
                }
                break;

            case "DELETE":
                try {
                    int deleteId = Integer.parseInt(payload.trim());
                    if (database.remove(deleteId) != null) {
                        System.out.println("BusinessLogicHandler: Deleted record with ID " + deleteId);
                    } else {
                        System.out.println("BusinessLogicHandler: No record found with ID " + deleteId);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("BusinessLogicHandler: Invalid ID format for deletion.");
                }
                break;

            default:
                System.out.println("BusinessLogicHandler: Unsupported action.");
        }

        super.handle(request);
    }
}