import rcs.command.MacroCommand;
import rcs.command.MoveCommand;
import rcs.command.PickItemCommand;
import rcs.command.PlaceItemCommand;
import rcs.invoker.CommandExecutor;
import rcs.receiver.WarehouseRobot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WarehouseRobot robot = new WarehouseRobot();
        CommandExecutor executor = new CommandExecutor();

        boolean running = true;

        while (running) {
            System.out.println("\n📦 Warehouse Robot Controller");
            System.out.println("1. Move Robot");
            System.out.println("2. Pick Item");
            System.out.println("3. Place Item");
            System.out.println("4. Execute Macro Command");
            System.out.println("5. Undo Last Command");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.print("Enter X coordinate: ");
                    int x = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Y coordinate: ");
                    int y = Integer.parseInt(scanner.nextLine());
                    executor.executeCommand(new MoveCommand(robot, x, y));
                    break;

                case "2":
                    System.out.print("Enter item name to pick: ");
                    String pickItem = scanner.nextLine();
                    executor.executeCommand(new PickItemCommand(robot, pickItem));
                    break;

                case "3":
                    System.out.print("Enter item name to place: ");
                    String placeItem = scanner.nextLine();
                    executor.executeCommand(new PlaceItemCommand(robot, placeItem));
                    break;

                case "4":
                    MacroCommand macro = new MacroCommand();
                    System.out.print("Enter number of commands in macro: ");
                    int n = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < n; i++) {
                        System.out.println("Add command #" + (i + 1) + " (MOVE/PICK/PLACE): ");
                        String cmdType = scanner.nextLine().trim().toUpperCase();

                        switch (cmdType) {
                            case "MOVE":
                                System.out.print("Enter X: ");
                                int mx = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter Y: ");
                                int my = Integer.parseInt(scanner.nextLine());
                                macro.addCommand(new MoveCommand(robot, mx, my));
                                break;

                            case "PICK":
                                System.out.print("Enter item name to pick: ");
                                String mPick = scanner.nextLine();
                                macro.addCommand(new PickItemCommand(robot, mPick));
                                break;

                            case "PLACE":
                                System.out.print("Enter item name to place: ");
                                String mPlace = scanner.nextLine();
                                macro.addCommand(new PlaceItemCommand(robot, mPlace));
                                break;

                            default:
                                System.out.println("Invalid macro command type.");
                        }
                    }

                    executor.executeCommand(macro);
                    break;

                case "5":
                    executor.undoLastCommand();
                    break;

                case "6":
                    running = false;
                    System.out.println("Exiting controller. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}