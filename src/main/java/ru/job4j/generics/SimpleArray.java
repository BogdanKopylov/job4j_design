package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = model;
    }
    public void set(int index, T model) {
        Objects.checkIndex(index, array.length);
        this.array[index] = model;

    }
    public void remove(int index) {
        Objects.checkIndex(index, array.length);
        T[] toArray = Arrays.copyOf(array, array.length - 1);
        if (index == 0) {
            System.arraycopy(array, 1, toArray, 0, array.length - 1);
        } else if (index == array.length - 1) {
            System.arraycopy(array, 0, toArray, 0, array.length - 1);
        } else {
            System.arraycopy(array, 0, toArray, 0, index);
            System.arraycopy(array, (index + 1), toArray, index, array.length - (index + 1));
        }
        this.array = toArray;
    }
    public T get(int index) {
        Objects.checkIndex(index, array.length);
        return this.array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < array.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[point++];
            }
        };
    }
}
