package javax.util.collection.queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {

    @Test
    public void push() {
        ArrayDeque<String> stack = new ArrayDeque<>();

        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals(3, stack.size());
    }

    @Test
    public void pushDuplicated() {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");
        stack.push("Android");

        assertEquals(4, stack.size());
        assertEquals(3, stack.stream().distinct().count());
    }


    @Test
    public void peek() {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals("Android", stack.peek());
        assertEquals(3, stack.size());
        assertEquals(true, stack.contains("Android"));
    }

    @Test
    public void pop() {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals("Android", stack.pop());
        assertEquals(2, stack.size());
        assertEquals(false, stack.contains("Android"));
    }

    @Test
    public void popAll() {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals("Android", stack.pop());
        assertEquals("Python", stack.pop());
        assertEquals("Java", stack.pop());

        assertEquals(0, stack.size());
        assertEquals(true, stack.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void popEmpty() {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals("Android", stack.pop());
        assertEquals("Python", stack.pop());
        assertEquals("Java", stack.pop());
        assertEquals(null, stack.pop());
    }
}
