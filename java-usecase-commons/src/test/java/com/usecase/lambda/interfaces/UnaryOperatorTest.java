package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.UnaryOperator;

import static org.junit.Assert.assertEquals;

public class UnaryOperatorTest {

    @Test
    public void apply() {
        //UnaryOperator<T> 接受一个参数为类型T,返回值类型也为T。
        UnaryOperator<Integer> func = x -> x + 1;

        Integer r = func.apply(1);
        assertEquals(Integer.valueOf(2), r);
    }
}
