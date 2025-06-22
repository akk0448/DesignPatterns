import fs.model.File;
import fs.model.Folder;
import fs.model.FileSystemItem;
import fs.utils.ConsolePrinter;

import java.util.Scanner;

public class FileSystemSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Folder root = new Folder("root");

        while (true) {
            ConsolePrinter.printHeading("📁 File System Simulator");
            ConsolePrinter.printMenuOption(1, "Add File to Root");
            ConsolePrinter.printMenuOption(2, "Add Folder to Root");
            ConsolePrinter.printMenuOption(3, "Add File to Folder");
            ConsolePrinter.printMenuOption(4, "Add Folder to Folder");
            ConsolePrinter.printMenuOption(5, "View Structure");
            ConsolePrinter.printMenuOption(6, "Get Total Size");
            ConsolePrinter.printMenuOption(7, "Exit");
            ConsolePrinter.printDivider();
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    System.out.print("Enter file size (KB): ");
                    int size = scanner.nextInt();
                    scanner.nextLine();
                    root.addItem(new File(fileName, size));
                    ConsolePrinter.printSuccess("File added to root.");
                }

                case 2 -> {
                    System.out.print("Enter folder name: ");
                    String folderName = scanner.nextLine();
                    root.addItem(new Folder(folderName));
                    ConsolePrinter.printSuccess("Folder added to root.");
                }

                case 3 -> {
                    System.out.print("Enter folder name to add file into: ");
                    String folderName = scanner.nextLine();
                    Folder target = findFolder(root, folderName);
                    if (target != null) {
                        System.out.print("Enter file name: ");
                        String fname = scanner.nextLine();
                        System.out.print("Enter file size (KB): ");
                        int fsize = scanner.nextInt();
                        scanner.nextLine();
                        target.addItem(new File(fname, fsize));
                        ConsolePrinter.printSuccess("File added to folder.");
                    } else {
                        ConsolePrinter.printError("Folder not found.");
                    }
                }

                case 4 -> {
                    System.out.print("Enter folder name to add new folder into: ");
                    String parentName = scanner.nextLine();
                    Folder parentFolder = findFolder(root, parentName);
                    if (parentFolder != null) {
                        System.out.print("Enter new folder name: ");
                        String newFolderName = scanner.nextLine();
                        parentFolder.addItem(new Folder(newFolderName));
                        ConsolePrinter.printSuccess("Folder added to folder.");
                    } else {
                        ConsolePrinter.printError("Parent folder not found.");
                    }
                }

                case 5 -> {
                    ConsolePrinter.printHeading("📂 File System Structure");
                    root.display("");
                }

                case 6 -> ConsolePrinter.printInfo("Total Size: " + root.getSize() + " KB");

                case 7 -> {
                    ConsolePrinter.printSuccess("Exiting File System Simulator. Goodbye!");
                    return;
                }

                default -> ConsolePrinter.printError("Invalid choice. Try again.");
            }
        }
    }

    private static Folder findFolder(Folder current, String name) {
        if (current.getName().equalsIgnoreCase(name)) {
            return current;
        }
        for (FileSystemItem item : current.getChildren()) {
            if (item instanceof Folder childFolder) {
                Folder result = findFolder(childFolder, name);
                if (result != null) return result;
            }
        }
        return null;
    }
}