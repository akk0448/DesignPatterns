package fs.utils;

public class ConsolePrinter {

    public static void printHeading(String heading) {
        System.out.println("\n=== " + heading + " ===");
    }

    public static void printMenuOption(int option, String description) {
        System.out.printf("%d. %s%n", option, description);
    }

    public static void printSuccess(String message) {
        System.out.println("✅ " + message);
    }

    public static void printInfo(String message) {
        System.out.println("ℹ️  " + message);
    }

    public static void printDivider() {
        System.out.println("-----------------------------");
    }

    public static void printError(String message) {
        System.out.println("❌ " + message);
    }
}