package object.chap11;

import java.util.EmptyStackException;
import java.util.Vector;

public class Stack<E> {

    private Vector<E> elements = new Vector<>();

    public E push(E item) {
        elements.add(item);
        return item;
    }

    public E pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }
}
