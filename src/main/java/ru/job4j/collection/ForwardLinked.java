package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;

    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T element = head.value;
        head = head.next;
        return element;
    }

    public boolean revert() {
        if (head != null && head.next != null) {
            Node<T> nxt = head.next;
            Node<T> prev = head;
            prev.next = null;
            while (nxt != null) {
                head = nxt;
                nxt = nxt.next;
                head.next = prev;
                prev = head;
            }
//            Node<T> help = head;
//            Node<T> help1;
//            head = head.next;
//            help.next = null;
//            help1 = head.next;
//            head.next = help;
//            while (help1 != null) {
//                help = help1;
//                help1 = help1.next;
//                help.next = head;
//                head = help;
//            }
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
