package com.usecase.util.collection.set;

import com.usecase.model.Season;
import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.assertEquals;

public class EnumSetTest {

    @Test
    public void allOf() {
        //集合元素就是 Season 枚举类的全部枚举值
        EnumSet<Season> enumSet = EnumSet.allOf(Season.class);

        assertSeasonElements(enumSet);

        System.out.println(enumSet);
    }

    private void assertSeasonElements(EnumSet<Season> enumSet) {
        assertEquals(4, enumSet.size());
        assertEquals(true, enumSet.contains(Season.SPRING));
        assertEquals(true, enumSet.contains(Season.SUMMER));
        assertEquals(true, enumSet.contains(Season.AUTUMN));
        assertEquals(true, enumSet.contains(Season.WINTER));
    }

    @Test
    public void of() {
        //集合元素就是 Season 枚举类的全部枚举值
        EnumSet<Season> enumSet = EnumSet.of(Season.SPRING);

        assertEquals(1, enumSet.size());
        assertEquals(true, enumSet.contains(Season.SPRING));

        System.out.println(enumSet);
    }

    @Test
    public void ofMultiElements() {
        //集合元素就是 Season 枚举类的全部枚举值
        EnumSet<Season> enumSet = EnumSet.of(Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER);

        assertSeasonElements(enumSet);

        System.out.println(enumSet);
    }


    @Test
    public void range() {
        //集合元素就是 Season 枚举类的全部枚举值
        EnumSet<Season> enumSet = EnumSet.range(Season.SPRING, Season.WINTER);

        assertSeasonElements(enumSet);

        System.out.println(enumSet);
    }

    @Test
    public void noneOf() {
        //创建一个 EnumSet 空集合，指定其集合元素是 Season 类的枚举值
        EnumSet<Season> enumSet = EnumSet.noneOf(Season.class);

        assertEquals(0, enumSet.size());
    }

    @Test
    public void add() {
        //集合元素就是 Season 枚举类的全部枚举值
        EnumSet<Season> enumSet = EnumSet.of(Season.SPRING);
        enumSet.add(Season.SUMMER);
        enumSet.add(Season.AUTUMN);
        enumSet.add(Season.WINTER);

        assertSeasonElements(enumSet);

        System.out.println(enumSet);
    }

    @Test
    public void addDuplicated() {
        //集合元素就是 Season 枚举类的全部枚举值
        EnumSet<Season> enumSet = EnumSet.of(Season.SPRING);
        enumSet.add(Season.SUMMER);
        enumSet.add(Season.AUTUMN);

        enumSet.add(Season.WINTER);
        enumSet.add(Season.WINTER);

        assertSeasonElements(enumSet);

        System.out.println(enumSet);
    }

    @Test
    public void complementOf() {
        EnumSet<Season> enumSet = EnumSet.noneOf(Season.class);
        enumSet.add(Season.SPRING);
        enumSet.add(Season.SUMMER);
        enumSet.add(Season.AUTUMN);

        EnumSet<Season> otherEnumSet = EnumSet.complementOf(enumSet);

        assertEquals(1, otherEnumSet.size());
        assertEquals(true, otherEnumSet.contains(Season.WINTER));

        System.out.println(otherEnumSet);
    }
}
