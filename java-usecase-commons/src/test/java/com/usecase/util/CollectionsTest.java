package com.usecase.util;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CollectionsTest {

    @Test(expected = NoSuchElementException.class)
    public void emptyIterator() {
        Iterator<Integer> numbers = Collections.emptyIterator();
        assertEquals(false, numbers.hasNext());

        numbers.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyListIterator() {
        ListIterator<Integer> numbers = Collections.emptyListIterator();
        assertEquals(false, numbers.hasNext());
        assertEquals(false, numbers.hasPrevious());
        assertEquals(0, numbers.nextIndex());
        assertEquals(-1, numbers.previousIndex());

        numbers.previous();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptyListIteratorAdd() {
        ListIterator<Integer> numbers = Collections.emptyListIterator();

        numbers.add(1);
    }

    @Test(expected = IllegalStateException.class)
    public void emptyListIteratorSet() {
        ListIterator<Integer> numbers = Collections.emptyListIterator();

        numbers.set(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyEnumeration() {
        Enumeration<Integer> numbers = Collections.emptyEnumeration();
        assertEquals(false, numbers.hasMoreElements());

        numbers.nextElement();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptyList() {
        //Returns an empty list (immutable).  This list is serializable.
        List<Integer> numbers = Collections.emptyList();
        assertEquals(0, numbers.size());

        numbers.add(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptySet() {
        //Returns an empty set (immutable).  This set is serializable.
        Set<Integer> numbers = Collections.emptySet();
        assertEquals(0, numbers.size());

        numbers.add(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptySortedSet() {
        SortedSet<Integer> numbers = Collections.emptySortedSet();
        assertEquals(0, numbers.size());

        numbers.add(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void emptySortedSetFirst() {
        SortedSet<Integer> numbers = Collections.emptySortedSet();
        assertEquals(0, numbers.size());

        numbers.first();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptyNavigableSet() {
        NavigableSet<Integer> numbers = Collections.emptyNavigableSet();
        assertEquals(0, numbers.size());

        numbers.add(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptyNavigableSetPollFirst() {
        NavigableSet<Integer> numbers = Collections.emptyNavigableSet();
        assertEquals(0, numbers.size());

        numbers.pollFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptyMap() {
        Map<Integer, String> numbers = Collections.emptyMap();
        assertEquals(0, numbers.size());

        numbers.put(1, "test");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptySortedMap() {
        Map<Integer, String> numbers = Collections.emptySortedMap();
        assertEquals(0, numbers.size());

        numbers.put(1, "test");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptyNavigableMap() {
        Map<Integer, String> numbers = Collections.emptyNavigableMap();
        assertEquals(0, numbers.size());

        numbers.put(1, "test");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void singleton() {
        Set<Integer> numbers = Collections.singleton(1);
        assertEquals(1, numbers.size());

        numbers.removeIf(x -> x == 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void singletonList() {
        List<Integer> numbers = Collections.singletonList(1);
        assertEquals(1, numbers.size());

        numbers.removeIf(x -> x == 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void singletonListReplaceAll() {
        List<Integer> numbers = Collections.singletonList(1);
        assertEquals(1, numbers.size());

        numbers.replaceAll(x -> x + 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void singletonMap() {
        Map<Integer, String> numbers = Collections.singletonMap(1, "test");
        assertEquals(1, numbers.size());

        numbers.put(2, "test2");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableCollection() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Collection<Integer> c = Collections.unmodifiableCollection(numbers);
        assertEquals(3, c.size());

        c.add(6);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableCollectionRemove() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Collection<Integer> c = Collections.unmodifiableCollection(numbers);
        assertEquals(3, c.size());

        c.remove(5);
    }

    private Set<Integer> buildSet() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        return numbers;
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableSet() {
        Set<Integer> numbers = buildSet();

        Set<Integer> c = Collections.unmodifiableSet(numbers);
        assertEquals(3, c.size());

        c.add(5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> c = Collections.unmodifiableList(numbers);
        assertEquals(3, c.size());

        c.add(5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableListRemove() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> c = Collections.unmodifiableList(numbers);
        assertEquals(3, c.size());

        c.remove(5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableListSort() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> c = Collections.unmodifiableList(numbers);
        assertEquals(3, c.size());

        c.sort(Comparator.comparingInt(x -> x));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "test1");
        map.put(2, "test2");

        Map<Integer, String> m = Collections.unmodifiableMap(map);
        m.put(3, "test3");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableSortedMap() {
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(1, "test1");
        map.put(2, "test2");

        Map<Integer, String> m = Collections.unmodifiableSortedMap(map);
        m.put(3, "test3");
    }

    @Test
    public void synchronizedCollection() {

    }

    @Test
    public void synchronizedSet() {

    }

    @Test
    public void synchronizedSortedSet() {

    }

    @Test
    public void synchronizedList() {

    }

    @Test
    public void synchronizedMap() {

    }

    @Test
    public void synchronizedSortedMap() {

    }

    @Test
    public void reverseOrder() {

    }

    @Test
    public void reverseOrderWithComparator() {

    }

    @Test
    public void enumeration() {

    }

    @Test
    public void list() {

    }

    @Test
    public void frequency() {

    }

    @Test
    public void disjoint() {

    }

    @Test
    public void addAll() {

    }

    @Test
    public void newSetFromMap() {

    }

    @Test
    public void asLifoQueue() {
        //返回 Deque 作为先进先出（ Lifo ） Queue 的视图
    }

    @Test
    public void sort() {

    }

    @Test
    public void sortWithComparator() {

    }

    @Test
    public void binarySearch() {

    }

    @Test
    public void reverse() {

    }

    @Test
    public void shuffle() {

    }

    @Test
    public void swap() {

    }

    @Test
    public void fill() {

    }

    @Test
    public void copy() {

    }

    @Test
    public void min() {

    }

    @Test
    public void max() {

    }

    @Test
    public void rotate() {

    }

    @Test
    public void replaceAll() {

    }

    @Test
    public void indexOfSubList() {

    }

    @Test
    public void lastIndexOfSubList() {

    }
}
