package rcs.invoker;

import rcs.command.Command;

import java.util.Stack;

public class CommandExecutor {

    private final Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        Command last = history.pop();
        last.undo();
    }
}