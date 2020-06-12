package com.usecase.util.map;

import com.usecase.model.Season;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.assertEquals;

public class EnumMapTest {

    @Test
    public void put() {
        EnumMap<Season, String> enumMap = buildEnumMap();

        assertEquals(4, enumMap.size());
        assertEquals(true, enumMap.containsKey(Season.SPRING));
        assertEquals(true, enumMap.containsKey(Season.SUMMER));
        assertEquals(true, enumMap.containsKey(Season.AUTUMN));
        assertEquals(true, enumMap.containsKey(Season.WINTER));
    }

    private EnumMap<Season, String> buildEnumMap() {
        EnumMap<Season, String> enumMap = new EnumMap<>(Season.class);

        enumMap.put(Season.SPRING, "春天");
        enumMap.put(Season.SUMMER, "夏天");
        enumMap.put(Season.AUTUMN, "秋天");
        enumMap.put(Season.WINTER, "冬天");
        return enumMap;
    }

    @Test
    public void get() {
        EnumMap<Season, String> enumMap = buildEnumMap();

        assertEquals("春天", enumMap.get(Season.SPRING));
        assertEquals("夏天", enumMap.get(Season.SUMMER));
        assertEquals("秋天", enumMap.get(Season.AUTUMN));
        assertEquals("冬天", enumMap.get(Season.WINTER));
    }
}
