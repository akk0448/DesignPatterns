package gmf.flyweight;

public class RockType implements MapElement {

    private final String shape;
    private final String hardness;

    public RockType(String shape, String hardness) {
        this.shape = shape;
        this.hardness = hardness;
    }

    @Override
    public void display(int x, int y) {
        System.out.printf("\uD83E\uDEA8 Rock [%s, Hardness: %s] at (%d, %d)%n", shape, hardness, x, y);
    }
}