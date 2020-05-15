package com.usecase.guava.common;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class OptionalTest {

    @Test
    public void of() {
        //创建指定引用的 Optional 实例，若引用为 null 则快速失败
        Optional<Integer> possible = Optional.of(5);

        assertTrue(possible.isPresent());
        assertEquals(true, possible.get() == 5);
    }

    @Test(expected = NullPointerException.class)
    public void ofNullException() {
        //创建指定引用的 Optional 实例，若引用为 null 则快速失败
        Optional.of(null);
    }

    @Test
    public void absent() {
        //创建引用缺失的 Optional 实例
        Optional<Integer> possible = Optional.absent();

        assertFalse(possible.isPresent());
    }

    @Test(expected = IllegalStateException.class)
    public void absentToGetException() {
        //创建引用缺失的 Optional 实例
        Optional<Integer> possible = Optional.absent();

        assertEquals(null, possible.get());
    }

    @Test
    public void isPresent() {
        Optional<Integer> possible = Optional.of(5);

        //如果 Optional 包含非 null 的引用（引用存在），返回true
        assertTrue(possible.isPresent());
    }


    @Test
    public void fromNullable() {
        //创建指定引用的 Optional 实例，若引用为 null 则表示缺失
        Optional<Integer> possible = Optional.fromNullable(5);

        assertTrue(possible.isPresent());
        assertEquals(true, possible.get() == 5);

        possible = Optional.fromNullable(null);
        assertFalse(possible.isPresent());
    }


    @Test(expected = IllegalStateException.class)
    public void fromNullableToGetException() {
        //创建指定引用的 Optional 实例，若引用为 null 则表示缺失
        Optional<Integer> possible = Optional.fromNullable(null);

        assertFalse(possible.isPresent());
        assertEquals(null, possible.get());
    }

    @Test
    public void or() {
        Optional<Integer> possible = Optional.fromNullable(null);
        assertFalse(possible.isPresent());

        //返回 Optional 所包含的引用，若引用缺失，返回指定的值
        Integer result = possible.or(1);
        assertEquals(true, result == 1);
    }

    @Test
    public void orWithValue() {
        Optional<Integer> possible = Optional.fromNullable(5);
        assertTrue(possible.isPresent());

        //返回 Optional 所包含的引用，若引用缺失，返回指定的值
        Integer result = possible.or(1);
        assertEquals(true, result == 5);
    }

    @Test
    public void orNull() {
        Optional<Integer> possible = Optional.fromNullable(null);
        assertFalse(possible.isPresent());

        //返回 Optional 所包含的引用，若引用缺失，返回
        Integer result = possible.orNull();
        assertEquals(null, result);
    }

    @Test
    public void orNullWithValue() {
        Optional<Integer> possible = Optional.fromNullable(5);
        assertTrue(possible.isPresent());

        //返回 Optional 所包含的引用，若引用缺失，返回
        Integer result = possible.orNull();
        assertEquals(true, result == 5);
    }

    @Test
    public void asSet() {
        Optional<Integer> possible = Optional.fromNullable(5);
        assertTrue(possible.isPresent());

        //如果引用存在，返回一个只有单一元素的集合
        Set result = possible.asSet();
        assertEquals(1, result.size());
    }

    @Test
    public void asSetWithNull() {
        Optional<Integer> possible = Optional.fromNullable(null);
        assertFalse(possible.isPresent());

        //返如果引用缺失，返回一个空集合。
        Set result = possible.asSet();
        assertEquals(true, result.isEmpty());
    }
}
