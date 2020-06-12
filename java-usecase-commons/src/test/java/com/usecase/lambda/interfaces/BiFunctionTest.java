package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;

public class BiFunctionTest {

    @Test
    public void apply() {
        //BiFunction<T,U,R> 代表了一个接受两个输入参数的方法，并且返回一个结果
        BiFunction<Integer, Long, Long> func = (x, y) -> x + y;

        Long r = func.apply(1, 2L);
        assertEquals(Long.valueOf(3), r);
    }
}
