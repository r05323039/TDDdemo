package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UndoRedoStackTest {
// If we add command 1 and then command 2,
// we can undo 2 only. after that, we can undo 1 or redo 2
// If we undo 1, then we can only redo 1, and then we can redo 2

// If we add command 1, then command 2, then undo 2, then add command 3
// When we undo 3, we can then redo 3 or undo 1
// When we undo 1, we can redo 1.
// If we redo 1, we can then undo 1 or redo 3.

    @Test
    void c1_c2_un2_c3_un3__re3() {
        UndoRedoStack stack = c1_c2_un2_c3_un3();
        assertEquals("redo command3", stack.redo());
    }

    @Test
    void c1_c2_un2_c3_un3__un1() {
        UndoRedoStack stack = c1_c2_un2_c3_un3();
        assertEquals("undo command1", stack.undo());
    }

    @Test
    void c1_c2_un2_c3_un3_un1__re1() {
        UndoRedoStack stack = c1_c2_un2_c3_un3();
        stack.undo();
        assertEquals("redo command1", stack.redo());
    }

    @Test
    void c1_c2_un2_c3_un3_un1_re1__un1() {
        UndoRedoStack stack = c1_c2_un2_c3_un3();
        stack.undo();
        stack.redo();
        assertEquals("undo command1", stack.undo());
    }

    @Test
    void c1_c2_un2_c3_un3_un1_re1__re3() {
        UndoRedoStack stack = c1_c2_un2_c3_un3();
        stack.undo();
        stack.redo();
        assertEquals("redo command3", stack.redo());
    }

    private UndoRedoStack c1_c2_un2_c3_un3() {
        UndoRedoStack stack = new UndoRedoStack();
        stack.command(new Command("command1"));
        stack.command(new Command("command2"));
        stack.undo();
        stack.command(new Command("command3"));
        stack.undo();
        return stack;
    }


    @Test
    void undo_previous_command_only() {
        UndoRedoStack stack = new UndoRedoStack();
        stack.command(new Command("command1"));
        stack.command(new Command("command2"));

        assertEquals("undo command2", stack.undo());
        assertEquals("undo command1", stack.undo());
    }

    @Test
    void undo_empty_then_throw() {
        UndoRedoStack stack = new UndoRedoStack();

        UndoRedoException e = assertThrows(UndoRedoException.class, () -> stack.undo());
        assertEquals("undo nothing", e.getMessage());
    }

    @Test
    void redo_previous_undo_only() {
        UndoRedoStack stack = new UndoRedoStack();
        stack.command(new Command("command1"));
        stack.command(new Command("command2"));

        stack.undo();
        stack.undo();
        assertEquals("redo command1", stack.redo());
        assertEquals("redo command2", stack.redo());
    }

    @Test
    void redo_empty_then_throw() {
        UndoRedoStack stack = new UndoRedoStack();

        UndoRedoException e = assertThrows(UndoRedoException.class, () -> stack.redo());
        assertEquals("redo nothing", e.getMessage());
    }

    @Test
    void command_clear_previous_redo() {
        UndoRedoStack stack = new UndoRedoStack();
        stack.command(new Command("command1"));
        stack.command(new Command("command2"));
        stack.undo();
        stack.command(new Command("command3"));
        UndoRedoException e = assertThrows(UndoRedoException.class, () -> stack.redo());
        assertEquals("redo nothing", e.getMessage());
    }
}