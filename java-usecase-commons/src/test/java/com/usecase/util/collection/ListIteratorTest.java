package com.usecase.util.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.assertEquals;

public class ListIteratorTest {

    @Test
    public void addByWhile() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Python");

        // 获取 books 集合对应的迭代器
        ListIterator<String> it = books.listIterator();
        while (it.hasNext()) {
            String book = it.next();
            it.add("---");
        }

        System.out.println(books);

    }

    @Test
    public void addByForEachRemaining() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Python");

        // 获取 books 集合对应的迭代器
        ListIterator<String> it = books.listIterator();
        it.forEachRemaining(x -> it.add("---"));

        System.out.println(books);
    }

    @Test
    public void remove() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Python");

        // 获取 books 集合对应的迭代器
        ListIterator<String> it = books.listIterator();
        while (it.hasNext()) {
            String book = it.next();
            if ("Java".equals(book)) {
                it.remove();
            }
        }

        assertEquals(false, books.contains("Java"));
    }
}
