package tdd;

import java.util.ArrayList;
import java.util.List;

public class IntStack {
    private List<Integer> elements = new ArrayList<>();

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(int element) {
        elements.add(0,element);
    }

    public int pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return elements.remove(0);
    }
}
