package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComparatorTest {

    @Test
    public void naturalOrder() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        int r = comparator.compare(1, 2);

        assertTrue(r < 0);
    }

    @Test
    public void reverseOrder() {
        Comparator<Integer> comparator = Comparator.reverseOrder();
        int r = comparator.compare(1, 2);

        assertTrue(r > 0);
    }

    @Test
    public void lambdaComparator() {
        Comparator<Integer> comparator = (x, y) -> x.compareTo(y);
        int r = comparator.compare(1, 2);

        assertTrue(r < 0);
    }

    @Test
    public void sortedWithNaturalOrderComparator() {
        List<Integer> numbers = Arrays.asList(4, 1, 2, 3);

        List<Integer> list = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(3));
    }

    @Test
    public void sortedWithLambdaComparator() {
        List<Integer> numbers = Arrays.asList(4, 1, 2, 3);

        List<Integer> list = numbers.stream()
                .sorted((x, y) -> y.compareTo(x))
                .collect(Collectors.toList());

        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(4), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
        assertEquals(Integer.valueOf(1), list.get(3));
    }

    @Test
    public void sortedWithReverseOrderComparator() {
        List<Integer> numbers = Arrays.asList(4, 1, 2, 3);

        List<Integer> list = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(4), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
        assertEquals(Integer.valueOf(1), list.get(3));
    }

    @Test
    public void comparing() {
        List<Integer> numbers = Arrays.asList(3, 1, 2);

        List<Integer> list = numbers.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .collect(Collectors.toList());

        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void comparingReversed() {
        List<Integer> numbers = Arrays.asList(3, 1, 2);

        List<Integer> list = numbers.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList());

        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(3), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(1), list.get(2));
    }
}
