package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveTwo() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeIf(input, e -> e % 2 == 0);
        assertThat(Arrays.asList(1, 3), Is.is(input));
    }

    @Test
    public void whenReplaceTwo() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.replaceIf(input, e -> e % 2 == 0, 0);
        assertThat(Arrays.asList(1, 0, 3, 0), Is.is(input));
    }

    @Test
    public void whenRemoveCollection() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 0, 3, 4));
        List<Integer> out = new ArrayList<>(Arrays.asList(0, 3));
        ListUtils.removeAll(input, out);
        assertThat(Arrays.asList(4), Is.is(input));
    }
}