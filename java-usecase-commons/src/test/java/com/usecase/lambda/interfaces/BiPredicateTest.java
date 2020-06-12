package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.BiPredicate;

import static org.junit.Assert.assertTrue;

public class BiPredicateTest {

    @Test
    public void test() {
        //BiPredicate<T,U> 代表了一个两个参数的boolean值方法
        BiPredicate<Integer, Long> func = (x, y) -> x > y;

        Boolean r = func.test(2, 1L);
        assertTrue(r);
    }
}
