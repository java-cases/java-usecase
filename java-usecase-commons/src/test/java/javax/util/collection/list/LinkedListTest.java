package javax.util.collection.list;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * LinkedList 同时表现出了双端队列、栈的用法
 */
public class LinkedListTest {

    @Test
    public void add() {
        LinkedList<String> books = new LinkedList<>();
        books.add("Java");
        books.add("Python");
        books.add("Android");
        books.add("Android");

        assertEquals(4, books.size());

        assertEquals(3, books.stream().distinct().count());
        assertEquals(true, books.stream().distinct().anyMatch(x -> x.equals("Java")));
        assertEquals(true, books.stream().distinct().anyMatch(x -> x.equals("Android")));
    }

    @Test
    public void offer() {
        LinkedList<String> books = new LinkedList<>();
        books.add("Java");
        books.add("Python");

        // 将字符串元素加入队列的尾部（双端队列）
        books.offer("Android");

        assertEquals(3, books.size());
        assertEquals("Java", books.getFirst());
        assertEquals("Android", books.getLast());
    }


    @Test
    public void offerFirst() {
        LinkedList<String> books = new LinkedList<>();
        books.add("Java");
        books.add("Python");

        // 将字符串元素添加到队列的头（相当于栈的顶部）
        books.offerFirst("Android");

        assertEquals(3, books.size());
        assertEquals("Android", books.getFirst());
        assertEquals("Python", books.getLast());
    }

    @Test
    public void offerLast() {
        LinkedList<String> books = new LinkedList<>();
        books.add("Java");
        books.add("Python");

        books.offerLast("Android");

        assertEquals(3, books.size());
        assertEquals("Java", books.getFirst());
        assertEquals("Android", books.getLast());
    }

    @Test
    public void push() {
        LinkedList<String> books = new LinkedList<>();
        books.add("Java");
        books.add("Python");

        // 将一个字符串元素加入栈的顶部（双端队列）
        books.push("Android");

        assertEquals(3, books.size());
        assertEquals("Android", books.getFirst());
        assertEquals("Python", books.getLast());
    }

    @Test
    public void peekFirstAndPeekLast() {
        LinkedList<String> books = new LinkedList<>();
        books.add("Java");
        books.add("Python");

        books.push("Android");

        // 访问，并不删除栈顶的元素
        assertEquals("Android", books.peekFirst());

        // 访问，并不删除队列的最后一个元素
        assertEquals("Python", books.peekLast());
    }

    @Test
    public void pop() {
        LinkedList<String> books = new LinkedList<>();
        books.add("Java");
        books.add("Python");

        books.push("Android");

        // 将栈顶的元素弹出
        assertEquals("Android", books.pop());
        assertEquals(false, books.contains("Android"));

        assertEquals("Java", books.peekFirst());
        assertEquals("Python", books.peekLast());
    }

    @Test
    public void pollLast() {
        LinkedList<String> books = new LinkedList<>();
        books.add("Java");
        books.add("Python");

        books.push("Android");

        // 访问，并删除队列的最后一个元素
        assertEquals("Python", books.pollLast());
        assertEquals(false, books.contains("Python"));

        assertEquals("Android", books.peekFirst());
        assertEquals("Java", books.peekLast());
    }
}
