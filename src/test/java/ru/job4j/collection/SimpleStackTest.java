package ru.job4j.collection;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {

    @Test
    public void whenAddOneElement() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push("one");
        String s = stack.pop();
        assertThat(s, is("one"));
    }

    @Test
    public void whenAddFirstThreeElements() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        String[] expected = new String[] {
                "three",
                "two",
                "one"
        };
        String[] actual = new String[] {
                stack.pop(),
                stack.pop(),
                stack.pop()
        };
        assertThat(actual, is(expected));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenPopEmptyStack() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.pop();
    }
}