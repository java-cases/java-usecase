package javax.util.collection.queue;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void push() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals(3, stack.size());
    }

    @Test
    public void pushDuplicated() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");
        stack.push("Android");

        assertEquals(4, stack.size());
        assertEquals(3, stack.stream().distinct().count());
    }


    @Test
    public void peek() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals("Android", stack.peek());
        assertEquals(3, stack.size());
        assertEquals(true, stack.contains("Android"));
    }

    @Test
    public void pop() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals("Android", stack.pop());
        assertEquals(2, stack.size());
        assertEquals(false, stack.contains("Android"));
    }

    @Test
    public void popAll() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals("Android", stack.pop());
        assertEquals("Python", stack.pop());
        assertEquals("Java", stack.pop());

        assertEquals(0, stack.size());
        assertEquals(true, stack.empty());
        assertEquals(true, stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void popEmpty() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Android");

        assertEquals("Android", stack.pop());
        assertEquals("Python", stack.pop());
        assertEquals("Java", stack.pop());
        assertEquals(null, stack.pop());
    }
}
