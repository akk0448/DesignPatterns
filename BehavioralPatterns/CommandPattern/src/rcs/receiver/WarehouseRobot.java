package rcs.receiver;

import rcs.model.Location;

import java.util.Stack;

public class WarehouseRobot {

    private final Stack<String> itemStack = new Stack<>();
    private Location currentLocation = new Location(0, 0);

    public void moveTo(int x, int y) {
        System.out.println("Robot moving from " + currentLocation + " to (" + x + "," + y + ")");
        currentLocation = new Location(x, y);
    }

    public void pick(String item) {
        System.out.println("Picked up item: " + item + " at location " + currentLocation);
        itemStack.push(item);
    }

    public void place(String item) {
        if (!itemStack.contains(item)) {
            System.out.println("Cannot place item: " + item + " – it’s not currently picked up.");
            return;
        }
        itemStack.remove(item);
        System.out.println("Placed item: " + item + " at location " + currentLocation);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public boolean isHolding(String item) {
        return itemStack.contains(item);
    }
}