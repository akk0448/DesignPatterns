package dtms.manager;

import dtms.model.Document;

import java.util.HashMap;
import java.util.Map;

public class DocumentManager {

    private final Map<String, Document> prototypeRegistry = new HashMap<>();

    public void registerPrototype(String key, Document prototype) {
        prototypeRegistry.put(key.toLowerCase(), prototype);
    }

    public Document getClonedDocument(String key) {
        Document prototype = prototypeRegistry.get(key.toLowerCase());
        if (prototype == null) {
            throw new IllegalArgumentException("No prototype found for key: " + key);
        }
        return prototype.cloneDocument();
    }

    public void listAvailablePrototypes() {
        System.out.println("\n📄 Available Prototypes:");
        prototypeRegistry.keySet().forEach(k -> System.out.println("- " + capitalize(k)));
    }

    private String capitalize(String input) {
        return input == null || input.isEmpty()
                ? input
                : input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}