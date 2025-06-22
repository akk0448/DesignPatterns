package fs.model;

public interface FileSystemItem {

    void display(String indent);

    int getSize();
}