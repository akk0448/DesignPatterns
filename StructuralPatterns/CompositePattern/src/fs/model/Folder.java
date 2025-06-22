package fs.model;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {

    private final String name;
    private final List<FileSystemItem> children;

    public String getName() {
        return name;
    }

    public List<FileSystemItem> getChildren() {
        return children;
    }

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addItem(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "📁 " + name);
        for (FileSystemItem item : children) {
            item.display(indent + "    ");
        }
    }

    @Override
    public int getSize() {
        return children.stream().mapToInt(FileSystemItem::getSize).sum();
    }
}