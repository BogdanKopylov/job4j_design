package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int inPoint = 0;
    private int outPoint = 0;

    public T poll() {
        if (outPoint == 0) {
            while (inPoint > 0) {
                out.push(in.pop());
                outPoint++;
                inPoint--;
            }
        }
        T i = out.pop();
        outPoint--;
        return i;
    }

    public void push(T value) {
        inPoint++;
        in.push(value);
    }
}
