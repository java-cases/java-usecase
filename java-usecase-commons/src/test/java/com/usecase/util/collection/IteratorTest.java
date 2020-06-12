package com.usecase.util.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IteratorTest {

    @Test
    public void iteratorWhile() {
        Set<String> books = new HashSet<>();
        books.add("Java");
        books.add("Android");
        books.add("Python");

        // 获取 books 集合对应的迭代器
        Iterator<String> it = books.iterator();
        while (it.hasNext()) {
            String book = it.next();
            System.out.println(book);
        }
    }

    @Test
    public void iteratorFor() {
        Set<String> books = new HashSet<>();
        books.add("Java");
        books.add("Android");
        books.add("Python");

        // 获取 books 集合对应的迭代器
        Iterator<String> it = books.iterator();
        for (String book : books) {
            System.out.println(book);
        }

        it.forEachRemaining(x -> System.out.println(x));
    }

    @Test
    public void iteratorForEachRemaining() {
        Set<String> books = new HashSet<>();
        books.add("Java");
        books.add("Android");
        books.add("Python");

        // 获取 books 集合对应的迭代器
        Iterator<String> it = books.iterator();
        it.forEachRemaining(x -> System.out.println(x));
    }

    @Test
    public void remove() {
        Set<String> books = new HashSet<>();
        books.add("Java");
        books.add("Android");
        books.add("Python");

        // 获取 books 集合对应的迭代器
        Iterator<String> it = books.iterator();
        while (it.hasNext()) {
            String book = it.next();
            if ("Java".equals(book)) {
                it.remove();
            }
        }

        assertEquals(false, books.contains("Java"));
    }
}
