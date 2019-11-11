package com.google.guava.collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ImmutableSortedSetTest {

    //不可变对象因为有固定不变，可以作为常量来安全使用。
    private static final ImmutableSortedSet<String> COLOR_NAMES = ImmutableSortedSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple");

    @Test
    public void of() {

        ImmutableSortedSet<String> colors = ImmutableSortedSet.of(
                "red",
                "orange",
                "yellow",
                "green",
                "blue",
                "purple");

        assertEquals(6, colors.size());

        assertEquals("blue", colors.first());
        assertEquals("yellow", colors.last());
    }

    @Test
    public void copyOfImmutableSet() {
        ImmutableSortedSet<String> colors = ImmutableSortedSet.copyOf(COLOR_NAMES);
        assertEquals(6, colors.size());
        assertEquals("blue", colors.first());
        assertEquals("yellow", colors.last());
    }

    @Test
    public void copyOfSortedSet() {
        ImmutableSortedSet<String> sorted = ImmutableSortedSet.copyOf(COLOR_NAMES);
        ImmutableSortedSet<String> colors = ImmutableSortedSet.copyOf(sorted);
        assertEquals(6, colors.size());
        assertEquals("blue", colors.first());
        assertEquals("yellow", colors.last());
    }

    @Test
    public void copyOfSorted() {
        ImmutableSortedSet<String> sorted = ImmutableSortedSet.copyOf(COLOR_NAMES);
        ImmutableSortedSet<String> colors = ImmutableSortedSet.copyOfSorted(sorted);
        assertEquals(6, colors.size());
        assertEquals("blue", colors.first());
        assertEquals("yellow", colors.last());
    }

    @Test
    public void copyOfReadonlyList() {
        List<String> readonlyList = Arrays.asList("red", "orange", "yellow",
                "green", "blue", "purple");

        ImmutableSortedSet<String> colors = ImmutableSortedSet.copyOf(readonlyList);
        assertEquals(6, colors.size());
        assertEquals("blue", colors.first());
        assertEquals("yellow", colors.last());
    }

    @Test
    public void copyOfList() {
        List<String> readonlyList = Arrays.asList("red", "orange", "yellow",
                "green", "blue", "purple");
        List<String> immutableList = new ArrayList<>();
        immutableList.addAll(readonlyList);

        ImmutableSortedSet<String> colors = ImmutableSortedSet.copyOf(immutableList);
        assertEquals(6, colors.size());
        assertEquals("blue", colors.first());
        assertEquals("yellow", colors.last());

        immutableList.clear();
        assertEquals(0, immutableList.size());
        assertEquals(6, colors.size());
    }

    @Test
    public void descendingSet() {
        ImmutableSortedSet<String> colors = ImmutableSortedSet.copyOf(COLOR_NAMES).descendingSet();
        assertEquals(6, colors.size());
        assertEquals("yellow", colors.first());
        assertEquals("blue", colors.last());
    }

    @Test
    public void naturalOrder() {
        ImmutableSortedSet colors = ImmutableSortedSet
                .naturalOrder()
                .addAll(COLOR_NAMES)
                .build();

        assertEquals(6, colors.size());
        assertEquals("blue", colors.first());
        assertEquals("yellow", colors.last());
    }

    @Test
    public void reverseOrder() {
        ImmutableSortedSet colors = ImmutableSortedSet
                .reverseOrder()
                .addAll(COLOR_NAMES)
                .build();

        assertEquals(6, colors.size());
        assertEquals("yellow", colors.first());
        assertEquals("blue", colors.last());
    }

    @Test
    public void orderedBy() {
        ImmutableSortedSet colors = ImmutableSortedSet
                .orderedBy((String x, String y) -> x.compareTo(y))
                .addAll(COLOR_NAMES)
                .build();

        assertEquals(6, colors.size());
        assertEquals("blue", colors.first());
        assertEquals("yellow", colors.last());
    }

    @Test
    public void asList() {
        ImmutableList colors = ImmutableSortedSet
                .naturalOrder()
                .addAll(COLOR_NAMES)
                .build()
                .asList();

        assertEquals(6, colors.size());
        assertEquals("blue", colors.get(0));
        assertEquals("yellow", colors.get(colors.size() - 1));
    }
}
