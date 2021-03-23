package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    public SimpleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
        this.modCount = 0;
    }

    @Override
    public void add(E value) {
        if (size > 1) {
            Node<E> node = last;
            last = new Node<>(node, value, null);
            node.next = last;
        } else if (size == 1) {
            last.item = value;
            last.prev = first;
            first.next = last;
        } else {
            first = new Node<>(null, value, null);
            last = new Node<>(null, value, null);
        }
        size++;
        modCount++;

    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> e = first;
        E it = e.item;
        for (int i = 0; i < size; i++) {
            if (index == i) {
                it = e.item;
            }
            e = e.next;
        }
        return it;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private Node<E> node = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                E item = node.item;
                node = node.next;
                return item;
            }
        };
    }
}