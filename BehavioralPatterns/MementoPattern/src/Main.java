import texteditor.editor.TextEditor;
import texteditor.history.History;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello");
        history.save(editor.save());

        editor.write(" World");
        history.save(editor.save());

        System.out.println("Current: " + editor.getContent());

        editor.restore(history.undo());
        System.out.println("After Undo 1: " + editor.getContent());

        editor.restore(history.undo());
        System.out.println("After Undo 2: " + editor.getContent());

        editor.restore(history.redo());
        System.out.println("After Redo 1: " + editor.getContent());
    }
}