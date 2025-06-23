package gmf.flyweight;

public class TreeType implements MapElement {

    private final String name;
    private final String color;
    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void display(int x, int y) {
        System.out.printf("\uD83C\uDF33 Tree [%s, %s, Texture: %s] at (%d, %d)%n", name, color, texture, x, y);
    }
}