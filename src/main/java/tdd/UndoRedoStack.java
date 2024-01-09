package tdd;

import java.util.ArrayDeque;
import java.util.Deque;

public class UndoRedoStack {
    private Deque<Command> undoStack = new ArrayDeque<>();
    private Deque<Command> redoStack = new ArrayDeque<>();

    public boolean command(Command command) {
        boolean add = undoStack.add(command);
        if(add){
            redoStack.clear();
        }
        return add;
    }

    public String undo() {
        if (undoStack.isEmpty()) {
            throw new UndoRedoException("undo nothing");
        }
        Command command = undoStack.removeLast();
        redoStack.add(command);
        return "undo " + command.getName();
    }

    public String redo() {
        if (redoStack.isEmpty()) {
            throw new UndoRedoException("redo nothing");
        }
        Command command = redoStack.removeLast();
        undoStack.add(command);
        return "redo " + command.getName();
    }
}
