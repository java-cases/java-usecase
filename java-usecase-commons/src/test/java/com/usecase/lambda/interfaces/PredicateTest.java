package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class PredicateTest {

    @Test
    public void test() {
        //Predicate<T> 接受一个输入参数，返回一个布尔值结果。
        Predicate<Integer> func = (x) -> x >1;

        Boolean r = func.test(2);
        assertTrue(r);
    }
}
