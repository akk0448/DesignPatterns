package rcs.command;

import rcs.receiver.WarehouseRobot;

public class MoveCommand implements Command {

    private final WarehouseRobot robot;
    private final int x, y;
    private int prevX, prevY;

    public MoveCommand(WarehouseRobot robot, int x, int y) {
        this.robot = robot;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        prevX = robot.getCurrentLocation().toString().charAt(1) - '0';
        prevY = robot.getCurrentLocation().toString().charAt(3) - '0';
        robot.moveTo(x, y);
    }

    @Override
    public void undo() {
        robot.moveTo(prevX, prevY);
        System.out.println("Undo move: Back to (" + prevX + "," + prevY + ")");
    }
}