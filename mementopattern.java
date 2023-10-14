package mementopattern;
import java.util.ArrayList;
import java.util.List;
public class Client {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor("Hello, World!");
        History history = new History();

        // Save the initial state
        history.addMemento(textEditor.save());

        // Make some changes
        textEditor.setContent("Hello, Galaxy!");
        // Save the new state
        history.addMemento(textEditor.save());

        // Make more changes
        textEditor.setContent("Hello, Universe!");

        // Restore the first state
        textEditor.restore(history.getMemento(0));
        System.out.println(textEditor.getContent());  // Output: Hello, World!

        // Restore the second state
        textEditor.restore(history.getMemento(1));
        System.out.println(textEditor.getContent());  // Output: Hello, Galaxy!
    }
}

class History {
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}

class Memento {
    private String content;

    public Memento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class TextEditor {
    private String content;

    public TextEditor(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento) {
        content = memento.getContent();
    }
}x