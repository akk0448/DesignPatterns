package rcs.command;

import rcs.receiver.WarehouseRobot;

public class PickItemCommand implements Command {

    private final WarehouseRobot robot;
    private final String item;

    public PickItemCommand(WarehouseRobot robot, String item) {
        this.robot = robot;
        this.item = item;
    }

    @Override
    public void execute() {
        robot.pick(item);
    }

    @Override
    public void undo() {
        if (robot.isHolding(item)) {
            System.out.println("Undo pick: Placing back item " + item);
            robot.place(item);
        } else {
            System.out.println("Undo pick: Robot is no longer holding item " + item);
        }
    }
}