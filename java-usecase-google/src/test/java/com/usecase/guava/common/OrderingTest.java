package com.usecase.guava.common;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OrderingTest {

    @Test
    public void from() {
        //把给定的 Comparator 转化为排序器
        Ordering<Integer> ordering = Ordering.from((x, y) -> x.compareTo(y));

        int r = ordering.compare(1, 2);
        assertEquals(true, r < 0);
    }

    @Test
    public void natural() {
        //对可排序类型做自然排序，如数字按大小，日期按先后排序
        Ordering<Integer> ordering = Ordering.natural();
        int r = ordering.compare(1, 2);
        assertEquals(true, r < 0);

        r = ordering.compare(2, 1);
        assertEquals(true, r > 0);

        r = ordering.compare(1, 1);
        assertEquals(true, r == 0);
    }

    @Test
    public void usingToString() {
        //按对象的字符串形式做字典排序
        Ordering<Object> ordering = Ordering.usingToString();
        int r = ordering.compare("a", "b");
        assertEquals(true, r < 0);

        r = ordering.compare("b", "a");
        assertEquals(true, r > 0);

        r = ordering.compare("a", "a");
        assertEquals(true, r == 0);
    }

    @Test
    public void reverse() {
        Ordering<Integer> ordering = Ordering.from((x, y) -> x.compareTo(y));

        //获取语义相反的排序器
        int r = ordering.reverse().compare(1, 2);
        assertEquals(true, r > 0);

        r = ordering.reverse().compare(2, 1);
        assertEquals(true, r < 0);

        r = ordering.reverse().compare(1, 1);
        assertEquals(true, r == 0);
    }

    @Test
    public void reverseWithString() {
        Ordering<String> ordering = Ordering.from((x, y) -> x.compareTo(y));

        //获取语义相反的排序器
        int r = ordering.reverse().compare("a", "b");
        assertEquals(true, r > 0);

        r = ordering.reverse().compare("b", "a");
        assertEquals(true, r < 0);

        r = ordering.reverse().compare("a", "a");
        assertEquals(true, r == 0);
    }

    @Test
    public void nullsFirst() {
        Ordering<String> ordering = Ordering.from((x, y) -> x.compareTo(y));

        //使用当前排序器，但额外把 null 值排到最前面。
        int r = ordering.nullsFirst().compare("a", null);
        assertEquals(true, r > 0);

        r = ordering.nullsFirst().compare(null, "a");
        assertEquals(true, r < 0);

        r = ordering.nullsFirst().compare(null, null);
        assertEquals(true, r == 0);
    }

    @Test
    public void nullsFirstWithoutNull() {
        Ordering<String> ordering = Ordering.from((x, y) -> x.compareTo(y));

        //使用当前排序器，但额外把 null 值排到最前面。
        int r = ordering.nullsFirst().compare("a", "b");
        assertEquals(true, r < 0);

        r = ordering.nullsFirst().compare("b", "a");
        assertEquals(true, r > 0);

        r = ordering.nullsFirst().compare("a", "a");
        assertEquals(true, r == 0);
    }

    @Test
    public void compound() {
        Ordering<String> ordering = Ordering.from((x, y) -> x.compareToIgnoreCase(y));

        //合成另一个比较器，以处理当前排序器中的相等情况。
        ordering.compound((x, y) -> x.compareTo(y));

        int r = ordering.compare("a", "b");
        assertEquals(true, r < 0);

        r = ordering.nullsFirst().compare("b", "a");
        assertEquals(true, r > 0);

        r = ordering.nullsFirst().compare("A", "a");
        assertEquals(true, r == 0);
    }

    @Test
    public void onResultOf() {
        //对集合中元素调用 Function，再按返回值用当前排序器排序。
        Ordering<Integer> ordering = Ordering.natural().onResultOf(x -> x % 2 + 1);

        int r = ordering.compare(1, 2);
        assertEquals(true, r > 0);

        r = ordering.nullsFirst().compare(2, 1);
        assertEquals(true, r < 0);

        r = ordering.nullsFirst().compare(1, 1);
        assertEquals(true, r == 0);
    }

    @Test
    public void greatestOf() {
        Ordering<Integer> ordering = Ordering.natural();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //获取可迭代对象中最大的k个元素。
        assertEquals(2, ordering.greatestOf(list, 2).size());
        assertEquals(true, ordering.greatestOf(list, 2).contains(10));
        assertEquals(true, ordering.greatestOf(list, 2).contains(9));
    }

    @Test
    public void leastOf() {
        Ordering<Integer> ordering = Ordering.natural();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertEquals(2, ordering.leastOf(list, 2).size());
        assertEquals(true, ordering.leastOf(list, 2).contains(1));
        assertEquals(true, ordering.leastOf(list, 2).contains(2));
    }

    @Test
    public void isOrdered() {
        Ordering<Integer> ordering = Ordering.natural();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //判断可迭代对象是否已按排序器排序：允许有排序值相等的元素。
        Boolean r = ordering.isOrdered(list);

        assertTrue(r);
    }

    @Test
    public void isOrderedFalse() {
        Ordering<Integer> ordering = Ordering.natural();
        List<Integer> list = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);

        //判断可迭代对象是否已按排序器排序：允许有排序值相等的元素。
        Boolean r = ordering.isOrdered(list);

        assertFalse(r);
    }


    @Test
    public void min() {
        Ordering<Integer> ordering = Ordering.natural();
        Integer r = ordering.min(2, 5);

        assertEquals(true, r == 2);
    }

    @Test
    public void minInParameterList() {
        Ordering<Integer> ordering = Ordering.natural();
        Integer r = ordering.min(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);

        assertEquals(true, r == 1);
    }

    @Test
    public void minInList() {
        Ordering<Integer> ordering = Ordering.natural();
        List<Integer> list = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer r = ordering.min(list);

        assertEquals(true, r == 1);
    }

    @Test
    public void max() {
        Ordering<Integer> ordering = Ordering.natural();
        Integer r = ordering.max(2, 5);

        assertEquals(true, r == 5);
    }

    @Test
    public void maxInParameterList() {
        Ordering<Integer> ordering = Ordering.natural();
        Integer r = ordering.max(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);

        assertEquals(true, r == 10);
    }

    @Test
    public void maxInList() {
        Ordering<Integer> ordering = Ordering.natural();
        List<Integer> list = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer r = ordering.max(list);

        assertEquals(true, r == 10);
    }


}
