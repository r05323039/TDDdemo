package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class IntStackTest {
    @Test
    void create__isEmpty() {
        IntStack stack = new IntStack();

        assertEquals(true, stack.isEmpty());
    }

    @Test
    void push_1__notEmpty() {
        IntStack stack = new IntStack();

        stack.push(1);

        assertEquals(false, stack.isEmpty());
    }

    @Test
    void push_1_pop__get1__isEmpty() throws StackEmptyException {
        IntStack stack = new IntStack();

        stack.push(1);

        assertEquals(1, stack.pop());
        assertEquals(true, stack.isEmpty());
    }

    @Test
    void isEmpty_pop_thorwException() {
        IntStack stack = new IntStack();
        assertEquals(true, stack.isEmpty());
        assertThrows(StackEmptyException.class, () -> stack.pop());
    }

    @Test
    void push_1_2_pop_pop__2__1() throws StackEmptyException {
        IntStack stack = new IntStack();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }
}