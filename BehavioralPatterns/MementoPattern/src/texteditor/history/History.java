package texteditor.history;

import texteditor.editor.EditorMemento;

import java.util.Stack;

public class History {
    private final Stack<EditorMemento> undoStack = new Stack<>();
    private final Stack<EditorMemento> redoStack = new Stack<>();

    public void save(EditorMemento memento) {
        undoStack.push(memento);
        redoStack.clear();
    }

    public EditorMemento undo() {
        if (!undoStack.isEmpty()) {
            EditorMemento last = undoStack.pop();
            redoStack.push(last);
            return !undoStack.isEmpty() ? undoStack.peek() : new EditorMemento("");
        }
        return new EditorMemento("");
    }

    public EditorMemento redo() {
        if (!redoStack.isEmpty()) {
            EditorMemento m = redoStack.pop();
            undoStack.push(m);
            return m;
        }
        return null;
    }
}