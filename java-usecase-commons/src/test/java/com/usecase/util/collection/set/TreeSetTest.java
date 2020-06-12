package com.usecase.util.collection.set;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TreeSetTest {

    @Test
    public void add() {
        //TreeSet 会调用集合元素的 compareTo(Object obj)方法来比较元素之间的大小关
        //系，然后将集合元素按升序排序，即自然排序
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(10);
        numbers.add(-10);

        assertEquals(4, numbers.size());
        assertEquals(Integer.valueOf(-10), numbers.first());
        assertEquals(Integer.valueOf(10), numbers.last());

        //集合元素已经处于排序状态
        System.out.println(numbers);
    }

    @Test
    public void addWithComparator() {
        TreeSet<Integer> numbers = new TreeSet<>((Integer x, Integer y) -> y.compareTo(x));
        numbers.add(5);
        numbers.add(1);
        numbers.add(10);
        numbers.add(-10);

        assertEquals(4, numbers.size());
        assertEquals(Integer.valueOf(10), numbers.first());
        assertEquals(Integer.valueOf(-10), numbers.last());

        //集合元素已经处于排序状态
        System.out.println(numbers);
    }

    @Test
    public void descendingIterator() {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(10);

        numbers.add(-10);

        Iterator<Integer> descendingIterator = numbers.descendingIterator();

        Set<Integer> descendingNumbers = new LinkedHashSet<>();
        descendingIterator.forEachRemaining(x -> descendingNumbers.add(x));

        assertEquals(Integer.valueOf(10), descendingNumbers.stream().findFirst().get());

        System.out.println(descendingNumbers);
    }

    @Test
    public void descendingSet() {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(10);
        numbers.add(-10);

        NavigableSet<Integer> descendingSet = numbers.descendingSet();
        assertEquals(Integer.valueOf(10), descendingSet.first());
        assertEquals(Integer.valueOf(-10), descendingSet.last());

        System.out.println(descendingSet);
    }

    @Test
    public void subSet() {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(10);
        numbers.add(-10);

        SortedSet<Integer> subSet = numbers.subSet(0, 6);

        assertEquals(false, subSet.isEmpty());
        assertEquals(2, subSet.size());
        assertEquals(Integer.valueOf(1), subSet.first());
        assertEquals(Integer.valueOf(5), subSet.last());

        System.out.println(subSet);
    }

    @Test
    public void headSet() {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(10);
        numbers.add(-10);

        SortedSet<Integer> subSet = numbers.headSet(6);

        assertEquals(false, subSet.isEmpty());
        assertEquals(3, subSet.size());
        assertEquals(Integer.valueOf(-10), subSet.first());
        assertEquals(Integer.valueOf(5), subSet.last());

        System.out.println(subSet);
    }

    @Test
    public void tailSet() {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(10);
        numbers.add(-10);

        SortedSet<Integer> subSet = numbers.tailSet(6);

        assertEquals(false, subSet.isEmpty());
        assertEquals(1, subSet.size());
        assertEquals(Integer.valueOf(10), subSet.first());
        assertEquals(Integer.valueOf(10), subSet.last());

        System.out.println(subSet);
    }
}
