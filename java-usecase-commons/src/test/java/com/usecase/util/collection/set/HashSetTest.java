package com.usecase.util.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HashSetTest {

    @Test
    public void add() {
        //HashSet 使用 HASH 算法来存储集合中的元素
        Set<String> books = new HashSet<>();
        books.add("Java");
        books.add("Android");
        books.add("Python");

        assertEquals(3, books.size());
        assertEquals("Java", books.stream().findFirst().get());

        books.stream().forEach(x -> System.out.println(x));
    }

    @Test
    public void addDuplicated() {
        //判断两个元素相等的标准是两个对象通过 equals()方法比较相等，并且两个对象的 hashCode()方法的返回值相等。
        Set<String> books = new HashSet<>();
        books.add("Java");
        books.add("Java");
        books.add("LittleHann");

        assertEquals(2, books.size());
        assertEquals(1, books.stream().filter(x -> x == "Java").count());

        books.stream().forEach(x -> System.out.println(x));
    }

}
