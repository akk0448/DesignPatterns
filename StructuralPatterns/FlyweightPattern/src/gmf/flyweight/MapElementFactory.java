package gmf.flyweight;

import java.util.HashMap;
import java.util.Map;

public class MapElementFactory {

    private static final Map<String, MapElement> cache = new HashMap<>();

    public static MapElement getTree(String name, String color, String texture) {
        String key = "Tree:" + name + ":" + color + ":" + texture;
        return cache.computeIfAbsent(key, k -> new TreeType(name, color, texture));
    }

    public static MapElement getRock(String shape, String hardness) {
        String key = "Rock:" + shape + ":" + hardness;
        return cache.computeIfAbsent(key, k -> new RockType(shape, hardness));
    }

    public static MapElement getHouse(String style, String material) {
        String key = "House:" + style + ":" + material;
        return cache.computeIfAbsent(key, k -> new HouseType(style, material));
    }
}