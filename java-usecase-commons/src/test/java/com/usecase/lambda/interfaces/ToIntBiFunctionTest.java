package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.ToIntBiFunction;

import static org.junit.Assert.assertEquals;

public class ToIntBiFunctionTest {

    @Test
    public void applyAsDouble() {
        //ToIntBiFunction<T,U> 接受两个输入参数，返回一个int类型结果。
        ToIntBiFunction<Integer, Long> func = (x, y) -> (int) (x + y);

        int r = func.applyAsInt(1, 2L);
        assertEquals(3, r);
    }
}
