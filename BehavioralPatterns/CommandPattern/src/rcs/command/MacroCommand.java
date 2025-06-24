package rcs.command;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {

    private final List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    @Override
    public void execute() {
        System.out.println("Executing macro command:");
        for (Command command : commandList) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        System.out.println("Undoing macro command:");
        for (int i = commandList.size() - 1; i >= 0; i--) {
            commandList.get(i).undo();
        }
    }
}