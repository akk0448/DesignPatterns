package gmf.model;

import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private final List<GameElement> elements = new ArrayList<>();

    public void addElement(GameElement element) {
        elements.add(element);
    }

    public void renderMap() {
        System.out.println("\n🌍 Game Map Elements:");
        for (GameElement element : elements) {
            element.render();
        }
    }
}