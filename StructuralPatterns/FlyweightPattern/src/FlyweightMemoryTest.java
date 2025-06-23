import java.util.ArrayList;
import java.util.List;

public class FlyweightMemoryTest {

    // Simulates flyweight: shared TreeType + individual coordinates
    static class TreeType {
        String name, color, texture;

        public TreeType(String name, String color, String texture) {
            this.name = name;
            this.color = color;
            this.texture = texture;
        }
    }

    static class Tree {
        int x, y;
        TreeType type;

        public Tree(int x, int y, TreeType type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    // Simulates non-flyweight: everything is separate
    static class FullTree {
        int x, y;
        String name, color, texture;

        public FullTree(int x, int y, String name, String color, String texture) {
            this.x = x;
            this.y = y;
            this.name = name;
            this.color = color;
            this.texture = texture;
        }
    }

    public static void main(String[] args) {
        int elementCount = 10_000_000;

        // Flyweight version
        List<Tree> flyweightTrees = new ArrayList<>();
        TreeType oak = new TreeType("Oak", "Green", "Rough");
        long startFly = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (int i = 0; i < elementCount; i++) {
            flyweightTrees.add(new Tree(i, i, oak));
        }
        long endFly = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Flyweight memory used: " + (endFly - startFly) / (1024 * 1024) + " MB");

        // Non-Flyweight version
        List<FullTree> fullTrees = new ArrayList<>();
        long startFull = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (int i = 0; i < elementCount; i++) {
            fullTrees.add(new FullTree(i, i, "Oak", "Green", "Rough"));
        }
        long endFull = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Without Flyweight memory used: " + (endFull - startFull) / (1024 * 1024) + " MB");
    }
}