package texteditor.editor;

public class TextEditor {
    private String content = "";

    public void write(String text) {
        content += text;
    }

    public void eraseLast(int chars) {
        if (chars <= content.length()) {
            content = content.substring(0, content.length() - chars);
        }
    }

    public String getContent() {
        return content;
    }

    public EditorMemento save() {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento) {
        if (memento != null) {
            this.content = memento.getContent();
        }
    }
}