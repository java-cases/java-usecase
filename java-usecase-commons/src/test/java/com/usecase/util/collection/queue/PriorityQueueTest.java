package com.usecase.util.collection.queue;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class PriorityQueueTest {

    @Test
    public void offer() {
        //自然排序
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("Java");
        queue.offer("Python");
        queue.offer("Android");

        assertEquals(3, queue.size());
        assertEquals("Android", queue.stream().findFirst().get());
    }

    @Test(expected = NullPointerException.class)
    public void offerNull() {
        PriorityQueue<String> queue = new PriorityQueue<>();

        //PriorityQueue 不允许插入 null 元素
        queue.offer(null);
    }

    @Test
    public void createPriorityQueueWithComparator() {
        //定制排序
        PriorityQueue<String> queue = new PriorityQueue<>((x, y) -> y.compareTo(x));
        queue.offer("Java");
        queue.offer("Python");
        queue.offer("Android");

        assertEquals(3, queue.size());
        assertEquals("Python", queue.stream().findFirst().get());
    }

    @Test
    public void peek() {
        //自然排序
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("Java");
        queue.offer("Python");
        queue.offer("Android");

        assertEquals("Android", queue.peek());
        assertEquals(3, queue.size());
        assertEquals(true, queue.contains("Android"));
    }

    @Test
    public void poll() {
        //自然排序
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("Java");
        queue.offer("Python");
        queue.offer("Android");

        assertEquals("Android", queue.poll());
        assertEquals(2, queue.size());
        assertEquals(false, queue.contains("Android"));
    }
}
