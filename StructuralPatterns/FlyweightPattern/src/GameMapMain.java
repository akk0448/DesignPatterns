import gmf.flyweight.MapElementFactory;
import gmf.model.GameElement;
import gmf.model.GameMap;

public class GameMapMain {
    public static void main(String[] args) {
        GameMap map = new GameMap();

        map.addElement(new GameElement(1, 1, MapElementFactory.getTree("Oak", "Green", "Rough")));
        map.addElement(new GameElement(2, 3, MapElementFactory.getTree("Pine", "Dark Green", "Smooth")));
        map.addElement(new GameElement(5, 2, MapElementFactory.getRock("Round", "Hard")));
        map.addElement(new GameElement(3, 5, MapElementFactory.getHouse("Cottage", "Wood")));
        map.addElement(new GameElement(6, 6, MapElementFactory.getTree("Oak", "Green", "Rough")));

        map.renderMap();
    }
}