package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.ToDoubleFunction;

import static org.junit.Assert.assertEquals;

public class ToDoubleFunctionTest {

    @Test
    public void applyAsDouble() {
        //ToDoubleFunction<T> 接受一个输入参数，返回一个double类型结果
        ToDoubleFunction<Integer> func = (x) -> x + 1;

        Double r = func.applyAsDouble(1);
        assertEquals(Double.valueOf(2), r);
    }
}
