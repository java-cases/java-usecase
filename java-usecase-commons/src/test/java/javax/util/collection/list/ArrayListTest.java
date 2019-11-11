package javax.util.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {

    @Test
    public void add() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");

        assertEquals(2, books.size());
        assertEquals(true, books.contains("Java"));
        assertEquals(true, books.contains("Android"));

        assertEquals("Java", books.stream().findFirst().get());

        System.out.println(books);
    }

    @Test
    public void addDuplicated() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Android");

        assertEquals(3, books.size());

        assertEquals(2, books.stream().distinct().count());
        assertEquals(true, books.stream().distinct().anyMatch(x -> x.equals("Java")));
        assertEquals(true, books.stream().distinct().anyMatch(x -> x.equals("Android")));

    }

    @Test
    public void indexOf() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Android");

        assertEquals(3, books.size());

        assertEquals(0, books.indexOf("Java"));
        assertEquals(1, books.indexOf("Android"));

    }

    @Test
    public void set() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Android");

        books.set(2, "Android 2nd");

        assertEquals(0, books.indexOf("Java"));
        assertEquals(1, books.indexOf("Android"));
        assertEquals(2, books.indexOf("Android 2nd"));
    }

    @Test
    public void remove() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Android");

        Boolean r = books.remove("Java");
        assertEquals(true, r);

        assertEquals(2, books.size());
        assertEquals(false, books.contains("Java"));
    }

    @Test
    public void removeDuplicated() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Android");

        Boolean r = books.remove("Android");
        assertEquals(true, r);

        assertEquals(2, books.size());
        assertEquals(true, books.contains("Android"));
    }

    @Test
    public void removeByIndex() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Android");

        String r = books.remove(2);
        assertEquals("Android", r);
        assertEquals(2, books.size());
        assertEquals(true, books.contains("Android"));

        r = books.remove(1);
        assertEquals("Android", r);
        assertEquals(1, books.size());
        assertEquals(false, books.contains("Android"));
    }

    @Test
    public void removeIf() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Android");

        Boolean r = books.removeIf(x -> x == "Java");
        assertEquals(true, r);

        assertEquals(2, books.size());
        assertEquals(false, books.contains("Java"));
    }

    @Test
    public void removeIfDuplicated() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Android");

        Boolean r = books.removeIf(x -> x == "Android");
        assertEquals(true, r);

        assertEquals(1, books.size());
        assertEquals(false, books.contains("Android"));
    }

    @Test
    public void removeAll() {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Android");
        books.add("Android");

        Boolean r = books.removeAll(Arrays.asList("Java", "Android"));
        assertEquals(true, r);

        assertEquals(0, books.size());
        assertEquals(false, books.contains("Java"));
        assertEquals(false, books.contains("Android"));
    }


    @Test
    public void subList() {
        List<String> books = new ArrayList<>();
        books.add("Android");
        books.add("Java");
        books.add("Android");

        List<String> subList = books.subList(1, 3);
        assertEquals(2, subList.size());
        assertEquals(true, subList.contains("Java"));
        assertEquals(true, subList.contains("Android"));
    }

    @Test
    public void subListFloor() {
        List<String> books = new ArrayList<>();
        books.add("Android");
        books.add("Java");
        books.add("Android");

        List<String> subList = books.subList(1, 2);
        assertEquals(1, subList.size());
        assertEquals(true, subList.contains("Java"));
        assertEquals(false, subList.contains("Android"));
    }
}
