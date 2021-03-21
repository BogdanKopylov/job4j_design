package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int count;

    public SimpleArray(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.count = 0;
    }

    public void add(T model) {
        if (count == array.length) {
            array = grow();
        }
        array[count++] = model;
    }
    
    private T[] grow() {
        return Arrays.copyOf(array, array.length * 2);
    }
    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        this.array[index] = model;

    }
    public void remove(int index) {
        Objects.checkIndex(index, count);
        if (index < count - 1) {
            System.arraycopy(array, (index + 1), array, index, count - 1 - index);
        }
            array[count - 1] = null;
            count--;
        }
/*
        if (index == 0) {
            System.arraycopy(array, 1, array, 0, count - 1);
            array[count - 1] = null;
            count--;
        } else if (index == count - 1) {
            array[count - 1] = null;
            count--;
        } else {
            System.arraycopy(array, (index + 1), array, index, count - 1 - index);
            count--;
        }
*/

    public T get(int index) {
        Objects.checkIndex(index, count);
        return this.array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < count;
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
