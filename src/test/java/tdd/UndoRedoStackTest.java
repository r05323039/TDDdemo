package tdd;

import static org.junit.jupiter.api.Assertions.*;

class UndoRedoStackTest {
// If we add command 1 and then command 2,
// we can undo 2 only. after that, we can undo 1 or redo 2
// If we undo 1, then we can only redo 1, and then we can redo 2

// If we add command 1, then command 2, then undo 2, then add command 3
// When we undo 3, we can then redo 3 or undo 1
// When we undo 1, we can redo 1.
// If we redo 1, we can then undo 1 or redo 3.
}