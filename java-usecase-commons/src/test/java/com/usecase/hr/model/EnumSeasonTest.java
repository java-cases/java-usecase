package com.usecase.hr.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EnumSeasonTest {

    @Test
    public void ofValue() {
        assertEquals(1, Season.of(1).getValue());
        assertEquals("spring", Season.of(1).getLabel());
        assertEquals("SPRING", Season.of(1).name());

        assertEquals(2, Season.of(2).getValue());
        assertEquals("summer", Season.of(2).getLabel());
        assertEquals("SUMMER", Season.of(2).name());

        assertEquals(3, Season.of(3).getValue());
        assertEquals("autum", Season.of(3).getLabel());
        assertEquals("AUTUMN", Season.of(3).name());

        assertEquals(4, Season.of(4).getValue());
        assertEquals("winter", Season.of(4).getLabel());
        assertEquals("WINTER", Season.of(4).name());
    }

    @Test
    public void ofLabel() {
        assertEquals(1, Season.of("spring").getValue());
        assertEquals("spring", Season.of("spring").getLabel());
        assertEquals("SPRING", Season.of("spring").name());
    }

    @Test
    public void valueOf() {
        assertEquals(1, Season.valueOf("SPRING").getValue());
        assertEquals("spring", Season.valueOf("SPRING").getLabel());
        assertEquals("SPRING", Season.valueOf("SPRING").name());
    }

    @Test
    public void values() {
        System.out.println(Arrays.toString(Season.values()));
    }

    @Test
    public void toStringOfSeason() {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }

}