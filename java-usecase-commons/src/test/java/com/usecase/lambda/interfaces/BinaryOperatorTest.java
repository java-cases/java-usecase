package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.BinaryOperator;

import static org.junit.Assert.assertEquals;

public class BinaryOperatorTest {

    @Test
    public void apply() {
        //BinaryOperator<T> 代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果
        BinaryOperator<Integer> func = (x, y) -> x + y;

        Integer r = func.apply(1, 2);
        assertEquals(Integer.valueOf(3), r);
    }
}
