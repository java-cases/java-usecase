package com.usecase.guava.collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ImmutableSetTest {

    //不可变对象因为有固定不变，可以作为常量来安全使用。
    private static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple");

    @Test
    public void of() {

        ImmutableSet<String> colors = ImmutableSet.of(
                "red",
                "orange",
                "yellow",
                "green",
                "blue",
                "purple");

        assertEquals(6, colors.size());

        assertEquals(true, colors.contains("red"));
        assertEquals(true, colors.contains("orange"));
        assertEquals(true, colors.contains("yellow"));
        assertEquals(true, colors.contains("green"));
        assertEquals(true, colors.contains("blue"));
        assertEquals(true, colors.contains("purple"));

        assertEquals("red", colors.asList().get(0));
        assertEquals("purple", colors.asList().get(colors.size() - 1));
    }

    @Test
    public void copyOfImmutableSet() {
        ImmutableSet<String> colors = ImmutableSet.copyOf(COLOR_NAMES);
        assertEquals(6, colors.size());
        assertEquals("red", colors.asList().get(0));
        assertEquals("purple", colors.asList().get(colors.size() - 1));
    }

    @Test
    public void copyOfReadonlyList() {
        List<String> readonlyList = Arrays.asList("red", "orange", "yellow",
                "green", "blue", "purple");

        ImmutableSet<String> colors = ImmutableSet.copyOf(readonlyList);
        assertEquals(6, colors.size());
        assertEquals("red", colors.asList().get(0));
        assertEquals("purple", colors.asList().get(colors.size() - 1));
    }

    @Test
    public void copyOfList() {
        List<String> readonlyList = Arrays.asList("red", "orange", "yellow",
                "green", "blue", "purple");
        List<String> immutableList = new ArrayList<>();
        immutableList.addAll(readonlyList);

        ImmutableSet<String> colors = ImmutableSet.copyOf(immutableList);
        assertEquals(6, colors.size());
        assertEquals("red", colors.asList().get(0));
        assertEquals("purple", colors.asList().get(colors.size() - 1));

        immutableList.clear();
        assertEquals(0, immutableList.size());
        assertEquals(6, colors.size());
    }

    @Test
    public void builder() {
        ImmutableSet<Object> colors = ImmutableSet.builder().addAll(COLOR_NAMES).build();
        assertEquals(6, colors.size());
    }

    @Test
    public void asList() {
        ImmutableList<String> colors = ImmutableSet.copyOf(COLOR_NAMES).asList();
        assertEquals(6, colors.size());
        assertEquals("red", colors.get(0));
        assertEquals("purple", colors.get(colors.size() - 1));
    }
}
