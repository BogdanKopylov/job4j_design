package ru.job4j.generics;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.lang.IndexOutOfBoundsException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    @Test
    public void whenAddThreeElements() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{0, 1, 2, 3});
        arr.add(4);
        arr.add(5);
        arr.add(6);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4, 5, 6};
        Integer[] actual = new Integer[]{arr.get(0), arr.get(1),
                arr.get(2), arr.get(3), arr.get(4), arr.get(5), arr.get(6)};
        assertThat(actual, is(expected));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenMethodGetIndexIsOutOfBounds() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{0, 1, 2, 3});
        arr.get(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenMethodSetIndexIsOutOfBounds() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{0, 1, 2, 3});
        arr.set(4, 7);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenMethodRemoveIndexIsOutOfBounds() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{0, 1, 2, 3});
        arr.remove(4);
    }

    @Test
    public void whenSetManyElements() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{10, 9, 8, 7, 6});
        arr.set(0, 0);
        arr.set(1, 1);
        arr.set(2, 2);
        arr.set(3, 3);
        arr.set(4, 4);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4};
        Integer[] actual = new Integer[]{arr.get(0), arr.get(1),
                arr.get(2), arr.get(3), arr.get(4)};
        assertThat(actual, is(expected));
    }

    @Test
    public void whenRemoveFirstElement() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{4, 0, 1, 2, 3, 4});
        arr.remove(0);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4};
        Integer[] actual = new Integer[]{arr.get(0), arr.get(1),
                arr.get(2), arr.get(3), arr.get(4)};
        assertThat(actual, is(expected));
    }

    @Test
    public void whenRemoveLastElement() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{0, 1, 2, 3, 4, 69});
        arr.remove(5);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4};
        Integer[] actual = new Integer[]{arr.get(0), arr.get(1),
                arr.get(2), arr.get(3), arr.get(4)};
        assertThat(actual, is(expected));
    }

    @Test
    public void whenRemoveOneElement() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{0, 1, 33, 2, 3, 4});
        arr.remove(2);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4};
        Integer[] actual = new Integer[]{arr.get(0), arr.get(1),
                arr.get(2), arr.get(3), arr.get(4)};
        assertThat(actual, is(expected));
    }

    @Test
    public void whenRemoveSomeElements() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{100, 0, 1, 33, 2, 3, 4, 66});
        arr.remove(0);
        arr.remove(6);
        arr.remove(2);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4};
        Integer[] actual = new Integer[]{arr.get(0), arr.get(1),
                arr.get(2), arr.get(3), arr.get(4)};
        assertThat(actual, is(expected));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenMethodRemoveAfterRemoveIndexIsOutOfBounds() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{0, 1, 2, 3});
        arr.remove(2);
        arr.get(3);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{});
        Iterator<Integer> it = arr.iterator();
        it.next();
    }

    @Test
    public void whenReadSequence() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{0, 1, 2, 3});
        Iterator<Integer> it = arr.iterator();
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenMultiCallhasNextThenTrue() {
        SimpleArray<Integer> arr = new SimpleArray<>(new Integer[]{0});
        Iterator<Integer> it = arr.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }
}