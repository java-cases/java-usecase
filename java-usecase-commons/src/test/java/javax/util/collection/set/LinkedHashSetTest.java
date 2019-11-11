package javax.util.collection.set;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LinkedHashSetTest {

    @Test
    public void add() {
        //LinkedHashSet根据元素的 hashCode 值来决定元素的存储位置
        Set<String> books = new LinkedHashSet<>();
        books.add("Java");
        books.add("LittleHann");

        assertEquals(2, books.size());
        assertEquals("Java", books.stream().findFirst().get());
    }

    @Test
    public void addDuplicated() {
        //LinkedHashSet根据元素的 hashCode 值来决定元素的存储位置
        Set<String> books = new LinkedHashSet<>();
        books.add("Java");
        books.add("Java");
        books.add("LittleHann");

        assertEquals("Java", books.stream().findFirst().get());
        assertEquals(2, books.size());
        assertEquals(1, books.stream().filter(x -> x == "Java").count());

    }

    @Test
    public void remove() {
        //LinkedHashSet根据元素的 hashCode 值来决定元素的存储位置
        Set<String> books = new LinkedHashSet<>();
        books.add("Java");
        books.add("LittleHann");

        books.remove("Java");
        books.add("Java");
        assertEquals("LittleHann", books.stream().findFirst().get());
    }
}
