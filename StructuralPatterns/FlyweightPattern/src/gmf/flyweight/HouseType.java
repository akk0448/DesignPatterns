package gmf.flyweight;

public class HouseType implements MapElement {

    private final String style;
    private final String material;

    public HouseType(String style, String material) {
        this.style = style;
        this.material = material;
    }

    @Override
    public void display(int x, int y) {
        System.out.printf("\uD83C\uDFE0 House [%s, Material: %s] at (%d, %d)%n", style, material, x, y);
    }
}