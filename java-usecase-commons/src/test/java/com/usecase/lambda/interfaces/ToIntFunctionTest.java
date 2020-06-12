package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.ToIntFunction;

import static org.junit.Assert.assertEquals;

public class ToIntFunctionTest {

    @Test
    public void applyAsDouble() {
        //ToIntFunction<T> 接受一个输入参数，返回一个int类型结果。
        ToIntFunction<Integer> func = (x) -> x + 1;

        int r = func.applyAsInt(1);
        assertEquals(2, r);
    }
}
