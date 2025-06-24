package rcs.command;

import rcs.receiver.WarehouseRobot;

public class PlaceItemCommand implements Command {

    private final WarehouseRobot robot;
    private final String item;

    public PlaceItemCommand(WarehouseRobot robot, String item) {
        this.robot = robot;
        this.item = item;
    }

    @Override
    public void execute() {
        robot.place(item);
    }

    @Override
    public void undo() {
        System.out.println("Undo place: Re-picking item " + item);
        robot.pick(item);
    }
}