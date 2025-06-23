package gmf.model;

import gmf.flyweight.MapElement;

public class GameElement {

    private final int x;
    private final int y;
    private final MapElement element;

    public GameElement(int x, int y, MapElement element) {
        this.x = x;
        this.y = y;
        this.element = element;
    }

    public void render() {
        element.display(x, y);
    }
}