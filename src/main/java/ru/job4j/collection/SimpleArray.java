package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArray(int capacity) {
        this.container = (T[]) new Object[capacity];
        this.size = 0;
        this.modCount = 0;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return this.container[index];
    }

    public void add(T model) {
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int point;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }
        };
    }
}